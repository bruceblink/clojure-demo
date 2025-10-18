(ns clojure.basic.destructuring-test
  (:require [clojure.test :refer :all]
            [clojure.basic.destructuring :refer :all]
            ))

(deftest destructure-test1
  (testing "FIXME, I Fail."
    (let [[musician scientist] people]
      (is "Rehmaan" musician)
      (is "Kalaam" scientist)
      )
    )
  )

(deftest destructure-test2
  (testing "FIXME, I Fail."
    (let [[_ scientist _ actor] people1]
      (is "Kalaam" scientist)
      (is "Madhavan" actor)
      )
    )
  )