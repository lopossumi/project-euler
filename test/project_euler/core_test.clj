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

(deftest euler004-test
  (testing "Euler 004"
    (is (= 1984
           (common/reverse-num 4891)))
    (println "Problem 004: " (time (euler004)))))

(deftest euler005-test
  (testing "Euler 005"
    (println "Problem 005: " (time (euler005)))))

(deftest euler006-test
  (testing "Euler 006"
    (is (= 121
           (common/square 11)))
    (println "Problem 006: " (time (euler006)))))

(deftest euler007-test
  (testing "Euler 007"
    (is (= 13
           (nth (common/lazy-primes) 5)))
    (println "Problem 007: " (time (euler007)))))

(deftest euler008-test
  (testing "Euler 008"
    (is (= '(1 2 3 4 5)
           (common/string-to-digits "12345")))
    (println "Problem 008: " (time (euler008)))))

(deftest euler009-test
  (testing "Euler 009"
    (println "Problem 009: " (time (euler009)))))

