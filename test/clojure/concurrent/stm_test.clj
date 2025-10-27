(ns clojure.concurrent.stm-test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.macro :refer :all]
            [criterium.core :as c]))

(defn transfer [from to amount]
  (dosync
    (alter from - amount)
    (alter to + amount)
    )
  )

(deftest ref-test
  (testing "test def ref"
    (let [my-ref (ref 0)]
      (is (= 0 @my-ref))
      )
    )

  (testing "test alter single ref" ;; 测试更新单个ref变量
    (let [my-ref (ref 0)]
      (is (= 0 @my-ref))       ;; 确认ref的初始基准值
      (dosync
        (ref-set my-ref 42)    ;; 设置ref
        )
      (is (= 42 @my-ref))      ;; 断言设置后的ref
      (dosync
        (alter my-ref inc)     ;; 更新ref
        )
      (is (= 43 @my-ref))      ;; 更新后的ref
      )
    )

  (testing "test alter multi ref"  ;; 测试更新多个ref
    (let [checking (ref 1000)
          savings (ref 2000)
          ]
      (transfer savings checking 100)    ;; savings向checking 转账 100
      (is (= 1100 @checking))
      (is (= 1900 @savings))
      )
    )
  )

(def attempts (atom 0))
(def transfers (agent 0))

(defn transfer1 [from to amount]
  (dosync
    (swap! attempts inc)      ;; 会产生副作用
    (send transfers inc)
    (alter from - amount)
    (alter to + amount)
    )
  )

(def checking (ref 10000))
(def savings (ref 20000))

(defn stress-thread [from to iterations amount]
  (Thread. #(dotimes [_ iterations] (transfer1 from to amount)))
  )

(deftest test-transaction
  (testing "test transaction"
    (println "Before: Checking =" @checking " Savings =" @savings)
    (let [t1 (stress-thread checking savings 100 100)
          t2 (stress-thread savings checking 200 100)]
      (.start t1)
      (.start t2)
      (.join t1)
      (.join t2)
      (await transfers)
      )
    (is (= 300 @transfers))
    (is (> @attempts @transfers))
    (println "Attempts: " @attempts )
    (println "Transfers:" @transfers )
    (println "After:  Checking =" @checking " Savings =" @savings)
    )
  )

(deftest test-use-commute-benchmark
  (testing "更精确的基准测试"
    (let [computation (apply + (range 1000))]
      (println "=== alter 基准测试 ===")
      (let [x (ref 0)]
        (c/quick-bench
          (wait-futures 5
                        (dotimes [_ 1000] (dosync (alter x + computation)))
                        (dotimes [_ 1000] (dosync (alter x - computation))))))

      (println "=== commute 基准测试 ===")
      (let [y (ref 0)]
        (c/quick-bench
          (wait-futures 5
                        (dotimes [_ 1000] (dosync (commute y + computation)))
                        (dotimes [_ 1000] (dosync (commute y - computation)))))))
    )
  )

;=== alter 基准测试 ===
;Evaluation count : 30 in 6 samples of 5 calls.         样本数：6个样本，每个样本包含5次调用，总共30次调用。
;Execution time mean : 24.588189 ms                     平均执行时间：24.588189 毫秒
;Execution time std-deviation : 731.767962 µs           标准偏差：731.767962 微秒（0.731毫秒），说明数据比较稳定
;Execution time lower quantile : 23.715039 ms ( 2.5%)
;Execution time upper quantile : 25.538987 ms (97.5%)   执行时间分位数：2.5%的分位数为23.715039毫秒，97.5%的分位数为25.538987毫秒，即大部分执行时间落在这个区间。
;Overhead used : 1.063419 ns                            1.063419 纳秒，这是基准测试框架本身的开销，非常小
;=== commute 基准测试 ===
;Evaluation count : 54 in 6 samples of 9 calls.
;Execution time mean : 11.952943 ms
;Execution time std-deviation : 649.886744 µs
;Execution time lower quantile : 11.140766 ms ( 2.5%)
;Execution time upper quantile : 12.702881 ms (97.5%)
;Overhead used : 1.063419 ns