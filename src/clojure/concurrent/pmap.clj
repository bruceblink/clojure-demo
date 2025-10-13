(ns clojure.concurrent.pmap)

(defn phone-numbers [string]
  (re-seq #"(\d{3})[\.-]?(\d{3})[\.-]?(\d{4})" string)
  )

(def files (repeat 1000 (
                         apply str
                               (concat (repeat 1000000 \space)
                                       "Sunil: 617.555.2937, Betty: 508.555.2218"
                                       ))))

(time (dorun (map phone-numbers files)))
;;
(time (dorun (pmap phone-numbers files)))    ;; 使用pmap
