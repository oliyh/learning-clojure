(ns learning-clojure.challenges.session2)

(defn tree [n]
  (let [max-width (- (* 2 n) 3)
        line (fn [stars] (println (apply str (concat (repeat (/ (- max-width stars) 2) " ") (repeat stars "*")))))]
    (doseq [x (concat (range 1 (inc max-width) 2) [1])]
      (line x))))

(defn treer [n]
  (loop [l 0]
    (let [stars (inc (* 2 l))]
      (println (apply str (concat (take (- n l) (repeat " ")) (take stars (repeat "*"))))))
    (if-not (< l (- n 2))
      (println (apply str (concat (take n (repeat " ")) ["*"])))
      (recur (inc l)))))