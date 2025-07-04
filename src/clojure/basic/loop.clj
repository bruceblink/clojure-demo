(ns clojure.basic.loop)
(defn loop-examples [n]
    (loop [i 0
           sum 0]
      (if (< i n)
        (recur (inc i) (+ sum i))
        sum
        )
      )
  )

