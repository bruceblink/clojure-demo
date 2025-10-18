(ns clojure.basic.recursion)

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