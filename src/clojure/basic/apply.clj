(ns clojure.basic.apply)

(println (apply hash-map [:a 5, :b 6]))   ;; {:a 5, :b 6}

(def args [2 -2 10])
(println (apply * 0.5 3 args))       ;; -60

