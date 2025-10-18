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