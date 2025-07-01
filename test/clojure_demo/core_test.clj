(ns clojure-demo.core-test
  (:require [clojure.test :refer :all]
            [clojure-demo.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (not (= 0 1))))
(deftest conj-test
  (testing "conj function"
    (is (= (conj [1 2 3] 4) [1 2 3 4]))
    (is (= (conj #{1 2} 3) #{1 2 3}))
    (is (= (conj '() 1) '(1)))
    (is (= (peek (list 1 2 3)) 1))
    )
  )