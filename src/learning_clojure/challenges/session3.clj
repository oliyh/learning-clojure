(ns learning-clojure.challenges.session3)

(defn sqrt [x] (java.lang.Math/sqrt x))

;; Euler examples
(defn multiples-of [limit & numbers]
  (reduce +
    (into #{}
      (mapcat (fn [x] (range x limit x)) numbers))))

(defn fib
  ([] (fib [0 1]))
  ([s]
  (let [[n0 n1] (take-last 2 s)]
    (lazy-seq (cons n0 (fib [n1 (+ n0 n1)]))))))


;; fib another way

(declare fib2*)

(defn fib2
  ([n]
    (println "Called with" n)
    (condp = n
      0 1
      1 1
      (+ (fib2* (- n 2)) (fib2* (dec n))))
    ))

(def fib2* (memoize fib2))

(defn fib-seq []
  (map fib2* (range)))

;; memoize caches results so that it will return in a reasonable time, performance is very bad!



(defn even-fib-below [limit]
  (filter even? (take-while #(< % limit) (fib))))

(defn whole? [x]
  (zero? (rem x 1)))

(defn factor?
  ([x] #(factor? x %))
  ([x y]
    (zero? (rem x y))))

(defn prime? [x]
  (and (whole? x)
    (empty? (filter #(and (whole? %) (factor? x %)) (range 2 (sqrt x))))))

(defn largest-prime-factor [n]
  (first (filter #(and (factor? n %) (prime? %)) (range (long (sqrt n)) 2 -1))))

(defn palindrome? [n]
  (let [s (str n)
        half (/ (count s) 2)]
    (and (whole? half) (= (take half s) (reverse (drop half s))))))

(defn largest-palindrome-product []
  (max (filter palindrome?
         (for [x (range 100 999)
               y (range 100 999)]
           (* x y)))))
