(ns clojure.basic.set-test
  (:require [clojure.test :refer :all]
            [clojure.basic.set :refer :all])
  (:import (clojure.lang PersistentHashSet))
  )

(deftest set-type
  (testing "FIXME, I fail."
    (is PersistentHashSet (type s))
    )
  )

(deftest set-api
  (testing "FIXME, I fail."
    (is #{1 4 3 2} s )
    (is (set? s))
    )
  )

(deftest fruits-set
  (testing "FIXME, I fail."
    (is (contains? fruits "Banana"))                        ;; test contains
    (is (fruits "Banana"))                                  ;; "banana" is fruit
    (not (contains? fruits "Watermelon"))                   ;; not contains
    )
  )

(deftest programming-language-test
  (testing "FIXME I fail."
    (is :ruby (programming-language :ruby))                 ;; because :ruby is keyword, it exists in set
    (is #{:clojure :python :perl :ruby} (conj programming-language :perl)) ;; test conj
    )
  )