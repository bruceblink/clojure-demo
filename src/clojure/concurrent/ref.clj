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

(defn add-new-user [login budget-amount]
  (dosync
    (let [current-number (count @all-users)
          user (new-user (inc current-number) login budget-amount)]
         (alter all-users assoc login user)
      )
    )
  )

(defn character
  "定义角色类型"
  [name & {:as opts}]
  (ref (merge {:name name
               :items #{}
               :health 500 } opts)
       )
  )

;; 定义具体角色
(def smaug (character "Smaug"
                      :health 500
                      :strength 400
                      :items (set (range 50))))

(def bilbo (character "Bilbo"
                      :health 100
                      :strength 100 ))

(def gandalf (character "Gandalf"
                      :health 75
                      :mana 750 ))

(defn loot
  "从一个角色瓜分(掠夺)另一个角色的装备"
  [from to]
  (dosync
    (when-let [item (first (:items @from))]
      (alter to update-in [:items] conj item )
      (alter from update-in [:items] disj item )
      )
    )
  )