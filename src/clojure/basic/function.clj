(ns clojure.basic.function)
(defn hypotenuse [a b]                                      ;; multiple arguments
  (Math/sqrt (+ (* a a) (* b b)))
  )

;; 定义不定参数函数
(defn unlimited-arguments [& args]
  (println "Arguments:" args)
  (println "Type of args:" (type args)))

(unlimited-arguments 1)                                     ;; Arguments: (1)
                                                            ;; Type of args: clojure.lang.ArraySeq
(println)
(unlimited-arguments 1 17 true "Karthik" :coder)            ;; Arguments: (1 17 true Karthik :coder)
                                                            ;; Type of args: clojure.lang.ArraySeq

(defn unlimited-arguments1 [first-arg & args]
  (println "First argument: " first-arg)
  (println "Other argument: " args)
  )

(unlimited-arguments1 1)                                     ;; First argument:  1
                                                             ;; Other argument:  nil

(unlimited-arguments1 1 17 true "Karthik" :coder)            ;; First argument:  1
                                                             ;; Other argument:  (17 true Karthik :coder)

(defn unlimited-arguments2 [first-arg second-arg & args]
  (println "First argument:" first-arg)
  (println "Second argument:" second-arg)
  (println "Other arguments:" args))

;; (unlimited-arguments2 1)   ;; 编译报错 Incorrect arity 1 for clojure.basic.function/unlimited-arguments2

(unlimited-arguments2 1 2)   ;; First argument: 1
                            ;; Second argument: 2


(unlimited-arguments2 1 17 true "Karthik" :coder)   ;; First argument: 1
                                                    ;; Second argument: 17
                                                    ;; Other arguments: (true Karthik :coder)

(defn x-chop
  ""
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate"))
  )