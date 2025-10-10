(ns clojure.concurrent.agent
  (:require [clojure.test :refer :all]
            ))


(deftest agent-test
  (testing "FIXME, I fail."
    (is @total-cpu-time 0 )
    (is (send total-cpu-time + 700) 700 )
    )
  )