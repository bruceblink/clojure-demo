(ns clojure.concurrent.ref_test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.ref :refer :all]
            [clojure.concurrent.macro :refer :all]))


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

(deftest test-ref-in-all
  (testing "test loot"
    (wait-futures 1
                  (while (loot smaug bilbo))                ;; bilbo 从 smaug 瓜分装备
                  (while (loot smaug gandalf))              ;; gandalf 从 smaug 瓜分装备
                  )
    (is (= {:name "Smaug" :items #{} :health 500 :strength 400} @smaug))
    (is (= 50 (reduce + (map (comp count :items deref) [bilbo gandalf])) )) ;; gandalf和bilbo瓜分smaug的装备总和为50
    )
  )