(ns clojure.basic.vector_test
  (:require [clojure.test :refer :all]
            [clojure.basic.vector :refer :all])
  (:import (clojure.lang PersistentVector)))

(deftest vector-test
  (testing "FIXME, I fail."
    (is (= v (vector 1 2 3 4)))
    (is (= "Ram" (first friends) ))
    (is (= ["Bashir" "Antony" "Buddha"] (rest friends) ))
    (is (= "Buddha" (friends 3) ))
    )
  )

(deftest vector-type
  (testing "FIXME, I fail."
    (is (= PersistentVector (type friends) ))
    )
  )
