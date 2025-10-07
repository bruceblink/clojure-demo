(ns clojure.concurrent.ref
  (:require [clojure.test :refer :all]
            [clojure.concurrent.ref :refer :all]
            ))


(deftest ref-test
  (testing "FIXME, I fail."
    (is (dosync
          (ref-set all-users {:a 1})
          )
        {:a 1}
        )
    )
  )