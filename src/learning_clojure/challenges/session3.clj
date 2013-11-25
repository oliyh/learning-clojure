(ns learning-clojure.challenges.session3)

(defn sqrt [x] (java.lang.Math/sqrt x))

;; Euler examples
(defn multiples-of [limit & numbers]
  (reduce +
    (into #{}
      (mapcat (fn [x] (range x limit x)) numbers))))

(defn fib
  ([] (fib 0 1))
  ([i j] (lazy-seq (cons i (fib j (+ i j))))))

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