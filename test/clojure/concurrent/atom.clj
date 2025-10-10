(ns clojure.concurrent.atom
  (:require [clojure.test :refer :all]))

(deftest agent-test
  (testing "FIXME, I fail."
    (is @total-rows 201 )
    (is (compare-and-set! total-rows 201 101) true )
    )
  )