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
;;;
(defn run-report [user]
  (println "Running report for user:" user))

(run-report "John Doe")

(defn dispatch-reporting-jobs [all-users]
  (doseq [user all-users]
    (run-report user)
    )
  )

(dispatch-reporting-jobs ["Alice" "Bob" "Charlie"])

(map inc (range 5))

(defn non-zero? [x]
  (if (zero? x)
    false
    true)
  )
(defn not-zero-expenses [expenses]
  (filter non-zero? expenses)
  )

(not-zero-expenses [-2 -1 0 1 2])

(defn factorial [n]
  (let [numbers (range 1 (+ n 1))]
    (reduce * 1 numbers)
    )
  )