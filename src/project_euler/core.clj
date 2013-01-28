(ns project-euler.core)

(require '[project-euler.common-math :as common])

(defn euler001
  "Returns the sum of all the multiples of 3 or 5 below 1000."
  []
  (reduce + (filter common/multiple-of-3-or-5? (range 1000))))

(defn euler002
  "Finds the sum of even-valued fibonacci numbers below 4 000 000."
  []
  (reduce + (filter even? (take-while (partial > 4000000) (common/fibs)))))

(defn euler003
  "Finds the largest prime factor of 600851475143."
  []
  (first (common/prime-factors 600851475143)))

(defn euler004
  "Finds the largest palindrome made from the product of two 3-digit numbers."
  []
  ("Write me!"))

(defn euler005
  "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
  []
  ("Write me!"))

(defn euler006
  "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
  []
  (- (square (reduce + (range 101)))
     (reduce + (map square (range 101)))))
