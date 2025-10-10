(ns clojure.concurrent.atom)
;; 定义atom
(def total-rows (atom 0)) ;; 0  @total-rows

(reset! total-rows 1)     ;; 1
(swap! total-rows + 100)  ;; 100
(compare-and-set! total-rows 101 201)   ;; true

