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

(deftest assoc-the-map-test
  (testing "FIXME, I fail."
    (is (= (assoc the-map :d 4) {:a 1 :b 2 :c 3 :d 4}))
    (is (= (assoc the-map :a 10) {:a 10 :b 2 :c 3}))
    (is (= (assoc the-map :e nil) {:a 1 :b 2 :c 3 :e nil}))
    )
  )

(deftest dissoc-the-map-test
  (testing "FIXME, I fail."
    (is (= (dissoc the-map :a) {:b 2 :c 3}))
    (is (= (dissoc the-map :b) {:a 1 :c 3}))
    (is (= (dissoc the-map :c) {:a 1 :b 2}))
    (is (= (dissoc the-map :d) {:a 1 :b 2 :c 3})) ; key not present
    )
  )
