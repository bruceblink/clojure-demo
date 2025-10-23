(ns clojure.basic.regular-test
  (:require [clojure.test :refer :all]))

(deftest test-regular
  (testing "test reqular expressions"
    (is (re-find #"^left-" "left-eye"))                     ;; 测试以left开头的字符串
    (not (re-find #"^left-" "cleft-chin"))                  ;;
    (is (re-find #"\d+" "672-345-456-3212"))                ;; 测试多个数字字符
    )
  )
