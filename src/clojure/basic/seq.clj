(ns clojure.basic.seq)

(defn seq-1 []
  (let [s (seq [1 2 3])]
    (println "seq-1:" s)))

(seq-1 )