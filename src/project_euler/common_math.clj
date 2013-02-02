(ns project-euler.common-math)

(defn divides?
  "Returns a predicate function: is x divisible by parameter?"
  [x]
  #(= 0 (mod x %)))

(defn multiple-of-3-or-5?
  [x]
  (or ((divides? x) 3)
      ((divides? x) 5)))

(defn square
  [x]
  (* x x))

(defn next-fib
  [[a b]]
  [(+ a b) a])

(defn prime?
  "Determines if a number is prime. Not efficient, yet."
  ([x] (->> (range 2 x)              ; List numbers from 2 to x-1
           (filter (divides? x))     ; leave the ones that evenly divide x
           (empty?)))                ; if none left, number is prime.

  ([x smaller-primes] (->> smaller-primes        ; Take a list of all the primes smaller than x
                          (filter (divides? x))  ; leave the ones that evenly divide x
                          (empty?))))            ; if none left, number is prime.

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

(defn lazy-primes
  "Horrible implementation of a lazy prime list."
  []
  (filter prime? (iterate inc 2)))

(defn string-to-digits
  [string]
  (map #(Character/getNumericValue %) string))

(defn reverse-num
  [x]
  "write me!")
