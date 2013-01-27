(ns project-euler.core)

(defn multiple-of-3-or-5?
  [x]
  (or (= 0 (mod x 3))
      (= 0 (mod x 5))))

(defn next-fib
  [[a b]]
  [(+ a b) a])

(defn fibs
  "Returns a lazy sequence of fibonacci numbers."
  []
  (map first (iterate next-fib [1 0])))

(defn euler001
  "Returns the sum of all the multiples of 3 or 5 below 1000."
  []
  (reduce + (filter multiple-of-3-or-5? (range 1000))))

(defn euler002
  "Finds the sum of even-valued fibonacci numbers below 4 000 000."
  []
  (reduce + (filter even? (take-while (partial > 4000000) (fibs)))))
