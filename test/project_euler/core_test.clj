(ns project-euler.core-test
  (:use clojure.test
        project-euler.core))

(require '[project-euler.common-math :as common])

(deftest euler001-test
  (testing "Euler 001"
    (is (common/multiple-of-3-or-5? 15))
    (is (not (common/multiple-of-3-or-5? 28)))
    (is (common/multiple-of-3-or-5? 9))
    (println "Problem 001: " (time (euler001)))))

(deftest euler002-test
  (testing "Euler 002"
    (is (= [3 2] (common/next-fib [2 1])))
    (is (= [1 1 2 3 5 8 13 21]
           (take 8 (common/fibs))))
    (println "Problem 002: " (time (euler002)))))

(deftest euler003-test
  (testing "Euler 003"
    (is (= [5 7 13 29]
           (sort (common/prime-factors 13195))))
    (println "Problem 003: " (time (euler003)))))
