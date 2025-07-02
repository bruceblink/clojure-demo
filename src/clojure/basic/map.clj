(ns clojure.basic.map)

(def the-map {:a 1 :b 2 :c 3})

(def users {
            :kyle {
                   :date-joined "2009-01-01"
                   :summary {
                             :average {
                                           :monthly 1000
                                           :yearly 12000
                                           }
                             }
                   }
            }
  )
