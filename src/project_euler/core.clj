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
  "Finds the largest palindrome made from 
  the product of two 3-digit numbers."
  []
  "Write me!")

(defn euler005
  "What is the smallest positive number that is 
  evenly divisible by all of the numbers from 1 to 20?"
  []
  (* 2 2 2 2 3 3 5 7 11 13 17 19)) ; Pen and paper

(defn euler006
  "Find the difference between the sum of the squares of the 
  first one hundred natural numbers and the square of the sum."
  []
  (- (common/square (reduce + (range 101)))
     (reduce + (map common/square (range 101)))))

(defn euler007
  "What is the 10 001st prime number?"
  []
  (nth (common/lazy-primes) 10000))

(def euler008-nu
  "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450")

(defn euler008
  "Find the greatest product of five consecutive digits in the 1000-digit number."
  []
  (loop [greatest 0
         digits   (common/string-to-digits euler008-nu)]
    (if (empty? digits) greatest
                       (recur (max greatest (reduce * (take 5 digits)))
                              (drop 1 digits)))))

(defn euler009
  "There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc."
  []
  (let [triplets (for [a (range 1 500)
                       b (range 1 500)
                        :when (< a b)]
                       [a b (Math/sqrt (+ (common/square a) (common/square b)))])]
    (int (reduce * (first (filter #(= 1000.0 (apply + %)) triplets))))))
