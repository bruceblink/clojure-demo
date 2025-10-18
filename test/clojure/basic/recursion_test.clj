(ns clojure.basic.recursion-test
  (:require [clojure.test :refer :all]
            [clojure.basic.recursion :refer :all] ))

(deftest recur-test
  (testing "FIXME , I Fail"
    (is 15 (my-sum [1 2 3 4 5], 0))
    (is 15 (my-sum1 [1 2 3 4 5]))
    (is 15 (my-sum2 [1 2 3 4 5]))
    (is 15 (my-sum3 [1 2 3 4 5]))
    )
  )
