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
  "等待所有future vector的值"
  [& args]
  `(doseq [f# (futures ~@args)]
     @f#
     )
  )
