(ns project-euler.core-test
  (:use clojure.test
        project-euler.core))

(deftest euler001-test
  (testing "Euler 001"
    (is (multiple-of-3-or-5? 15))
    (is (not (multiple-of-3-or-5? 28)))
    (is (multiple-of-3-or-5? 9))
    (println "Problem 001: " (euler001))))

(deftest euler002-test
  (testing "Euler 002"
    (is (= [3 2] (next-fib [2 1])))
    (is (= [1 1 2 3 5 8 13 21]
           (take 8 (fibs))))
    (println "Problem 002: " (euler002))))


