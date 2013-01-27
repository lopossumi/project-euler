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
