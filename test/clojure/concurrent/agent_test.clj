(ns clojure.concurrent.agent_test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.agent :refer :all]
            ))


(deftest agent-test
  (testing "FIXME, I fail."
    (is @total-cpu-time 0 )
    (is (send total-cpu-time + 700) 700 )
    )
  )