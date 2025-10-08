(ns clojure.concurrent.ref)

(def all-users (ref {}))

(defn new-user [id login monthly-budget]
  {
   :id id
   :login login
   :monthly-budget monthly-budget
   :total-expenses 0
   }
  )
