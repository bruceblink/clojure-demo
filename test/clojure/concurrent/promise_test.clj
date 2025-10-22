(ns clojure.concurrent.promise-test
  (:require [clojure.test :refer :all]))

(deftest promise-test-1
  (testing "promise test"
    (let [p (promise)]
      (not (realized? p))       ;; 检测是否获取到promise的值
      (deliver p 42)            ;; 填充 promise
      (is (realized? p))
      )
    )
  )
