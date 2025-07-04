(ns clojure.basic.loop-test
  (:require [clojure.test :refer :all]
            [clojure.basic.loop :refer :all]))

(deftest the-map-test
  (testing "FIXME, I fail."
    (is (= (loop-examples 4 ) 6))
    )
  )

(deftest test-filter
  (testing "filter non-zero expenses"
    (is (= (not-zero-expenses [-2 -1 0 1 2]) [-2 -1 1 2]))
    )
  )