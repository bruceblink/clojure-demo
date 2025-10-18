(ns clojure.basic.recursion
  (:require [clojure.core.reducers :as r])
  )

;; 定义递归函数
(defn count-down [number]
  (println number)
  (if (pos? (dec number))       ;; pos? Returns true if num is greater than zero, else false
    (count-down (dec number))   ;; recursive call count-down
    )
  )

;;(count-down 5)
;; 5
;; 4
;; 3
;; 2
;; 1

;; use recur keyword
(defn count-down-recur [number]
  (println number)
  (if (pos? (dec number))
    (recur (dec number))
    )
  )

;;(count-down-recur 5)
;; 5
;; 4
;; 3
;; 2
;; 1

(defn my-sum [numbers total]
  (if (empty? numbers)
    total
    (recur (rest numbers) (+ total (first numbers)))
    )
  )

;; 简化my-sum
(defn my-sum1 [numbers]
  (if (empty? numbers)
    0
    (+ (first numbers) (my-sum1 (rest numbers)))
    )
  )
;; 优化my-sum1
(defn my-sum2 [numbers]
  (reduce (fn [acc x] (+ acc x)) 0 numbers)
  )
;; 继续优化my-sum1
(defn my-sum3 [numbers]
  (reduce + numbers)
  )
;; 并行sum
(defn parallel-sum [numbers]
  (r/fold + numbers)
  )
;; 普通sum
(defn sum [numbers]
  (reduce + numbers)
  )
(def numbers (into [] (range 0 10000000)))
(time (sum numbers))                  ;; "Elapsed time: 67.7645 msecs"
(time (parallel-sum numbers))         ;; "Elapsed time: 37.2484 msecs"