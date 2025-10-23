(ns clojure.basic.function-test
  (:require [clojure.test :refer :all]
            [clojure.basic.function :refer :all])
  )

(deftest test-hypotenuse
  (testing "FIXME, I fail."
    (is 5 (hypotenuse 3 4))
    )
  )

(deftest test-x-chop
  (testing "test function override"                           ;; 测试函数重载
    (is (= "I slap chop Kanye West! Take that!" (x-chop "Kanye West" "slap")) )
    (is (= "I karate chop Kanye East! Take that!" (x-chop "Kanye East")) )
    )
  )

(deftest test-destructuring-parameters
  (testing "test destructuring first parameters "
    (is (= "oven" (return-first-element ["oven" "bike" "war-axe"])))
    )

  (testing "test destructuring mulity parameters "
    (is (= ["oven" "bike"] (return-mulity-parameters ["oven" "bike" "war-axe" "swift"])))
    )
  )
