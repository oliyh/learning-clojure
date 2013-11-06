(ns learning-clojure.challenges.session2
  (:use [clojure.math.numeric-tower]))

(defn tree [n]
  (let [max-width (- (* 2 n) 3)
        line (fn [stars] (println (apply str (concat (repeat (/ (- max-width stars) 2) " ") (repeat stars "*")))))]
    (doseq [x (concat (range 1 (inc max-width) 2) [1])]
      (line x))))

;; Euler examples
(defn multiples-of [limit & numbers]
  (reduce +
    (into #{}
      (mapcat (fn [x] (range x limit x)) numbers))))

(defn fib
  ([] (fib [1 2]))
  ([s] (let [next (apply + (take-last 2 s))
             nnext (+ (last s) next)]
         (concat s (lazy-seq (fib [next nnext]))))))

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