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

(deftest ref-alter-test
  (testing "FIXME, I fail."
      (is
          (add-new-user "amit" 1000000)
          {
              "amit" {
                  :id 2,
                  :login "amit",
                  :monthly-budget 1000000,
                  :total-expenses 0
                  }
              }
          )
      )
  )