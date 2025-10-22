(ns clojure.concurrent.delay_test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.delay :refer :all]))

(deftest agent-test
  (testing "FIXME, I fail."
    (is @long-calculation 4999999950000000 )
    )
  )

;; 使用 deliver 更新 promise
(deftest promise-test
  (testing "FIXME, I fail."
    (is (deliver p 42)  42 )
    )
  )