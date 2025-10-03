(ns clojure.basic.reduce)

(println (reduce max [0 -3 10 48]))     ;; 48

(println (reduce + 50 [1, 2, 3, 4]))      ;; 60

(println
  (reduce
    (fn [m v]
      (assoc m v (* v v)))
    {}
    [1 2 3 4])
  )        ;; {1 1, 2 4, 3 9, 4 16}

