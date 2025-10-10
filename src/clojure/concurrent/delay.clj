(ns clojure.concurrent.delay)
(def d (delay (println "Running...")
              :done!
              ))       ;;  Running...

(def p (promise))

(def long-calculation (future (apply + (range 1e8))))
