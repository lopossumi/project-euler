(ns project-euler.common-math)


(defn divides?
  "Returns a predicate function: is x divisible by parameter?"
  [x]
  #(zero? (mod x %)))


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


(defn fibs
  "Returns a lazy sequence of fibonacci numbers."
  []
  (map first (iterate next-fib [1 0])))


(defn prime?
  "Determines if a number is prime. Not efficient, yet."
  ([x]                (->> (range 2 x)           ; List numbers from 2 to x-1
                           (filter (divides? x)) ; leave the ones that evenly divide x
                           (empty?)))            ; if none left, number is prime.

  ([x smaller-primes] (->> smaller-primes         ; List of primes smaller than x
                           (filter (divides? x))  ; leave the ones that evenly divide x
                           (empty?))))            ; if none left, number is prime.


(defn prime-factors
  "Returns the prime factors of x as a sequence.
  (with duplicates, largest first)"
  [x]
  (loop [factors []
         iter 2
         x x]
         (cond
           (< x iter)           factors

           ((divides? x) iter)  (recur (cons iter factors)
                                       iter
                                       (/ x iter))

           :else                (recur factors
                                       (inc iter)
                                       x))))


(def prime-gen
  "Fast, lazy prime sequence."
    (let [primes (atom [])]
        (for [n (iterate inc 2)
            :when (odd? n)
            :when (not-any? (divides? n) 
                            (filter #(<= % (Math/sqrt n)) @primes))]
            (do (swap! primes conj n) 
                n))))


(defn string-to-digits
  [string]
  (map #(Character/getNumericValue %) string))


(defn reverse-num
  [x]                        ;1234
  (->>  (str x)              ;"1234"
        (reverse)            ;(\4 \3 \2 \1)
        (apply str)          ;"4321"
        (Integer/parseInt))) ;4321


(defn number-of-divisors
  [x]
 ; (->>  (prime-factors x)
 )
        
