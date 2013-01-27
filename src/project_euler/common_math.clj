(ns project-euler.common-math)

(defn multiple-of-3-or-5?
  [x]
  (or (= 0 (mod x 3))
      (= 0 (mod x 5))))

(defn divides?
  "Returns a predicate function: is x divisible by parameter?"
  [x]
  #(= 0 (mod x %)))

(defn next-fib
  [[a b]]
  [(+ a b) a])

(defn prime?
  "Determines if a number is prime. Not efficient, yet."
  [x]
  (empty? (filter (divides? x) (range 2 x))))

(defn fibs
  "Returns a lazy sequence of fibonacci numbers."
  []
  (map first (iterate next-fib [1 0])))

(defn prime-factors
  "Returns the prime factors of x as a sequence."
  [x]
  (loop [factors []
         iter 2
         divided x]
         (cond
           (< divided iter) factors
           ((divides? divided) iter) (recur (cons iter factors)
                                      iter
                                      (/ divided iter))
           :else (recur factors
                        (inc iter)
                        divided))))
