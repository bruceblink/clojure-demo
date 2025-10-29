(ns clojure.concurrent.agent-test
  (:require [clojure.test :refer :all]
            [clojure.concurrent.agent :refer :all]
            ))


(deftest agent-test
  (testing "FIXME, I fail."
    (is @total-cpu-time 0 )
    (is (send total-cpu-time + 700) 700 )
    )
  )

(deftest agent-update
  (testing "agent update"
    (let [a (agent 500)]
      ;; 异步发送任务
      (send a (fn [_] (range 1000)))
      ;; 等待所有 agent 完成（非常重要）
      (await a)
      ;; 测试状态是否更新正确
      (is (= (range 1000) @a)))
    )
  )

(deftest multiple-agents
  (testing "multiple agent updates"
    (let [agents (repeatedly 10 #(agent 0))]
      (doseq [a agents]
        (send a (fn [_] (Thread/sleep 100) 42))             ;; 异步将所有的agent的值设置为42
        )
      (apply await agents)                                  ;; 等待 agent 更新完成
      (is (every? #(= 42 @%) agents))
      )
    )
  )

(deftest update-agents-immediately
  (testing "agent updates immediately"
    ;; 1. 创建一个初始状态为0的Agent
    (let [my-agent (agent 0)]
      ;; 2. 使用send-off发送一个更新函数
      (send-off my-agent (fn [current-val]
                           (Thread/sleep 1000) ; 模拟一个耗时的阻塞操作
                           (println "模拟阻塞任务 ...")
                           (inc current-val)))
      ;; 3. 立即检查agent的值，可能还是旧值（因为send-off是异步的）
      (println @my-agent) ; 很可能输出 0
      ;; 4. 等待所有派发给该agent的任务完成
      (await my-agent)
      (println @my-agent) ; 等待后输出 1
      )
    )
  )