(ns clojure.concurrent.macro)

(defmacro futures
  "生成 future 的 vector"
  [n & exprs]
  (vec (for [_ (range n)     ;; 列表生成式
             expr exprs
             ]
         `(future ~expr)
         )
       )
  )

(defmacro wait-futures
  "Return一个vector: 等待所有future的值的vector"
  [& args]
  `(doseq [f# (futures ~@args)]
     @f#
     )
  )
