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