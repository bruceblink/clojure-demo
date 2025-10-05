(ns clojure.basic.compose)

(defn negated-sum-str
  [& numbers]
  (str (- (apply + numbers)))
  )
(println (negated-sum-str 10 12 3.4) )       ;; "-25.4"

(def negated-sum-str1 (comp str - +))
(println (negated-sum-str1 10 12 3.4) )      ;; "-25.4"

(require '[clojure.string :as str])
(def caml->keyword (comp keyword
                         str/join
                         (partial interpose \-)
                         (partial map str/lower-case)
                         #(str/split % #"(?<=[a-z])(?=[A-Z])"))) ;;找到一个位置，它左边是小写字母，右边是大写字母。

(println (caml->keyword "CamelCase"))    ;; :camel-case