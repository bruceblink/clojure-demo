(ns clojure.basic.for-test
  (:require [clojure.test :refer :all]
            [clojure.basic.for :refer :all])
  )

(deftest test-for
  (testing "FIXME, I Fail."
    (is '(10 20 30 40) nums*10)
    (is colors-shapers colors*shapes)
    )
  )
