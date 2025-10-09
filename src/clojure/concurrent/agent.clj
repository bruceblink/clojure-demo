(ns clojure.concurrent.agent)
;; 定义agent
(def total-cpu-time (agent 0))
;; 使用send 更新 agent
(println (send total-cpu-time + 700) )   ;; 700

