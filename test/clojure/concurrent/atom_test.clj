(ns clojure.concurrent.atom-test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.macro :refer :all]))

(deftest atom-test
  (testing "FIXME, I fail."
    (let [total-rows (atom 0)]
      (is (= 0 @total-rows))
      (reset! total-rows 100)                               ;; init atom
      (is (= 100 @total-rows))
      (swap! total-rows + 100 )
      (is (= 200 @total-rows) )              ;; update atom
      (not (compare-and-set! total-rows 200 "101"))         ;; 此处cas无法更新total-rows
      (is (compare-and-set! total-rows @total-rows "101"))  ;; cas不使用值语义，它要求atom的值跟你传入它的第二个参数必须一样(必须是相同对象(identical))
      (reset! total-rows 100)                               ;; 重置 total-rows
      (is (compare-and-set! total-rows 100 101))            ;; 这个可以更新成功的原因是Clojure会对数据进行boxed (Java中的装箱将基本类型转成对象)
      (is (identical? -128 -128))                           ;; 对于整数类型的数据 在byte范围相同的数据装箱后是同一对象
      (is (identical? 127 127))
      (is (compare-and-set! total-rows 101 128))            ;; 将total-rows更新为128
      (is (= 128 @total-rows))
      (not (compare-and-set! total-rows 128 200))           ;; 此时的数字128和 @total-rows并不是同一对象，所以更新失败
      (not (identical? 128 @total-rows))
      (is (identical? @total-rows @total-rows))
      (is (compare-and-set! total-rows @total-rows 200))    ;; 此时若是要更新total-rows， 我们必须使用@total-rows作为old_value参数的值
      )
    )
  )

(deftest test-update-atom
  (testing "update in atom"
    (let [sarah (atom {:name "Sarah" :age 25 :wear-glasses? false})]
      (is (= {:name "Sarah" :age 25 :wear-glasses? false} @sarah))
      (swap! sarah update-in [:age] + 3)
      (is (= {:name "Sarah" :age 28 :wear-glasses? false} @sarah))
      )
    )

  (testing "test future atom"
    (let [xs (atom #{1 2 3})]
      (wait-futures 1 (swap! xs #(do
                                   (Thread/sleep 250)
                                   (println "trying 4")
                                   (conj % 4)))
                      (swap! xs (fn [v]
                                  (Thread/sleep 500)
                                  (println "trying 5")
                                  (conj v 5)))
                    )
      ;; print打印输出结果是如下
      ;; trying 4
      ;; trying 5
      ;; trying 5
      (is (= #{1 2 3 4 5} @xs))
      )
    )
  )

(deftest atom-def-test
  (testing "deref atom"
    (let [my-atom (atom 42)]
                 (is (= 42 @my-atom))
                 (is (= 42 (deref my-atom)))
                 (is (= @my-atom (deref my-atom)))
                 )
    )
  )

(deftest atom-update
  (let [my-atom (atom 42)]
               (testing "update atom1"
                 (is (= 43 (swap! my-atom inc))))
               (testing "update atom2"
                 (is (= 45 (swap! my-atom + 2))))  ;; 注意这里是从 43 -> 45
               )
  )


(deftest atom-validator
  (testing "use validator"
    (let [non-negative (atom 0 :validator #(>= % 0))]
      ;; 成功情况
      (is (= 42 (reset! non-negative 42)))  ;; ✅ 正确断言写法
      ;; 失败情况
      (is (thrown? IllegalStateException    ;; thrown? 只能运行在clojure.test中
                   (reset! non-negative -1))) ;; ✅ 会抛出异常
      ;; 确认值未被修改
      (is (= 42 @non-negative))
      )
    )
  )

(deftest atom-watcher
  (testing "use watcher"
    (let [a (atom 0)
          out (with-out-str                      ;; 捕获 println 输出
                (add-watch a :print
                           #(println "Changed from" %3 "to" %4))
                (swap! a + 2))]                   ;; 触发 watcher

      (is (re-find #"Changed from 0 to 2" out))   ;; 验证输出字符串
      (is (= 2 @a))
      )
    )
  )

(deftest atom-watcher-with-redefs
  (testing "use watcher with redefs"
    (let [a (atom 0)
          called (atom nil)
          ]
      (with-redefs [println (fn [& args] (reset! called args))] ;; 使用 with-redefs 替换 println 输出
        (add-watch a :print
                   #(println "Changed from" %3 "to" %4))
        (swap! a + 2)
        )
      (is (= ["Changed from" 0 "to" 2] @called))   ;; 验证输出字符串
      (is (= 2 @a))
      )
    )
  )