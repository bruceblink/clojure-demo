(ns clojure.basic.keyword)

(defn keyword-example []
  (let [k1 :foo
        k2 :bar
        k3 :foo
        ]
    (println "Keyword 1:" k1)
    (println "Keyword 2:" k2)
    (println "Are they equal?" (= k1 k2))
    (println "Are they equal?" (= k1 k3))
    (println "Keyword with namespace:" :clojure.core/keyword)))

(keyword-example)


