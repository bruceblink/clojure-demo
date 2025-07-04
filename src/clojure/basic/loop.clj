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

(defn run-report [user]
  (println "Running report for user:" user))

(run-report "John Doe")

(defn dispatch-reporting-jobs [all-users]
  (doseq [user all-users]
    (run-report user)
    )
  )

(dispatch-reporting-jobs ["Alice" "Bob" "Charlie"])

(dotimes [x 5]
  (println "x is:" x))

(map inc (range 5))