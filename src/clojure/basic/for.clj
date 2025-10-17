(ns clojure.basic.for)

(def nums*10 (let [nums [1 2 3 4]]
               (for [num nums]
                 (* num 10)
                 )
               )
  )

(def colors ["red" "blue" "green" "yellow"])
(def shapes ["square" "circle" "triangle" "rectangle"])


(def colors*shapes  (for [color colors
                          shape shapes]
                      (str color " " shape)
                      )
  )

(def colors-shapers
  '("red square" "red circle" "red trangle" "red rectangle" "blue square" "blue circle" "blue trangle" "blue rectangle" "green square" "green circle" "green trangle" "green rectangle" "yellow square" "yellow circle" "yellow trangle" "yellow rectangle")
  )