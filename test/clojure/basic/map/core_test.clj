(ns clojure.basic.map.core_test
  (:require [clojure.test :refer :all]
            [clojure.basic.map.map :refer :all]))

(deftest the-map-test
  (testing "FIXME, I fail."
    (is (= (the-map :a)  (:a the-map) 1))
    (is (= (the-map :b)  (:b the-map) 2))
    (is (= (the-map :c)  (:c the-map) 3))
    )
  )
