(ns clojure.basic.partial)

;; 定义函数部分函数
(def only-strings (partial filter string?))
(println (only-strings ["a", 5, "b", 6]))

(#(filter string? %) ["a", 5, "b", 6])      ;; 等价于 (fn [x] (filter string? x))
(#(filter % ["a", 5, "b", 6]) string?)      ;; 等价于 (fn [pred] (filter pred ["a" 5 "b" 6]))

(println (#(map * % %2 %3) [1 2 3] [4 5 6] [7 8 9]))        ;; (28 80 162)

(println (#(apply map * %&) [1 2 3] [4 5 6] [7 8 9]))       ;; (28 80 162)

(println ((partial map *) [1 2 3] [4 5 6] [7 8 9]))         ;; (28 80 162)