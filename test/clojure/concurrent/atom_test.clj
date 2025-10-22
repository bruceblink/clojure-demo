(ns clojure.concurrent.atom-test
  (:require [clojure.test :refer :all]))

(deftest atom-test
  (testing "FIXME, I fail."
    (let [total-rows (atom 0)]
      (is (= 0 @total-rows))
      (reset! total-rows 100)                               ;; init atom
      (is (= 100 @total-rows))
      (swap! total-rows + 100 )
      (is (= 200 @total-rows) )              ;; update atom
      (is (compare-and-set! total-rows 200 201))           ;; CAS success
      (is (= 201 @total-rows))
      )
    )
  )