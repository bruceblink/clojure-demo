(ns clojure.basic.map-test
  (:require [clojure.test :refer :all]
            [clojure.basic.map :refer :all]))

(deftest the-map-test
  (testing "FIXME, I fail."
    (is (= (the-map :a)  (:a the-map) 1))
    (is (= (the-map :b)  (:b the-map) 2))
    (is (= (the-map :c)  (:c the-map) 3))
    )
  )

(deftest assoc-the-map-test
  (testing "FIXME, I fail."
    (is (= (assoc the-map :d 4) {:a 1 :b 2 :c 3 :d 4}))
    (is (= (assoc the-map :a 10) {:a 10 :b 2 :c 3}))
    (is (= (assoc the-map :e nil) {:a 1 :b 2 :c 3 :e nil}))
    )
  )

(deftest dissoc-the-map-test
  (testing "FIXME, I fail."
    (is (= (dissoc the-map :a) {:b 2 :c 3}))
    (is (= (dissoc the-map :b) {:a 1 :c 3}))
    (is (= (dissoc the-map :c) {:a 1 :b 2}))
    (is (= (dissoc the-map :d) {:a 1 :b 2 :c 3})) ; key not present
    )
  )
(deftest get-in-the-map-test
  (testing "FIXME, I fail.")
    (is (= (get-in users [:kyle :summary :average :monthly] ) 1000))
    (is (= (get-in users [:kyle :summary :average :yearly] ) 12000))
  )

(deftest assoc-in-the-map-test
  (testing "FIXME, I fail.")
    (is (= (assoc-in users [:kyle :summary :average :monthly] 2000)
           {:kyle {:date-joined "2009-01-01"
                   :summary {:average {:monthly 2000
                                       :yearly 12000}}}}))
    (is (= (assoc-in users [:kyle :summary :average :yearly] 24000)
           {:kyle {:date-joined "2009-01-01"
                   :summary {:average {:monthly 1000
                                       :yearly 24000}}}}))
  )

(deftest update-in-the-map-test
  (testing "FIXME, I fail.")
  (is (= (update-in users [:kyle :summary :average :monthly] + 500)
         {:kyle {:date-joined "2009-01-01"
                 :summary {:average {:monthly 1500
                                     :yearly 12000}}}})
      )
  (is (= (update-in users [:kyle :summary :average :yearly] * 2)
         {:kyle {:date-joined "2009-01-01"
                 :summary {:average {:monthly 1000
                                     :yearly 24000}}}})
      )
  )