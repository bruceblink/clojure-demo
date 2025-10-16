(ns clojure.basic.list_test
  (:require [clojure.test :refer :all]
            [clojure.basic.list :refer :all])
  (:import (clojure.lang PersistentList)))

(deftest a-test
  (testing "FIXME, I fail."
    (not (= 0 1))
    )
  )

(deftest conj-test
  (testing "conj function"
    (is (= (conj [1 2 3] 4) [1 2 3 4]))
    (is (= (conj #{1 2} 3) #{1 2 3}))
    (is (= (conj '() 1) '(1)))
    (is (= (peek (list 1 2 3)) 1))
    (is (= '(1 2 3) (list 1 2 3)))
    (is (= 4 (count friends-list)))                                ;; 计数
    (is (= "Ram" (first friends-list)))                            ;; 第一个元素
    (is (= '("Bashir" "Antony" "Buddha") (rest friends-list)))     ;; 剩余元素
    (is (= "Buddha" (nth friends-list 3)))                         ;; index为3的元素， index从0开始
    (is (= PersistentList (type friends-list)))             ;; 查看类型
    )
  )