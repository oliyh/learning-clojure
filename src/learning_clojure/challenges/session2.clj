(ns learning-clojure.challenges.session2
  (:use [clojure.math.numeric-tower]))

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

;; java comparison
;;    public void printLine(int maxWidth, int numStars) {
;;        repeat((maxWidth - numStars) / 2, " ");
;;        repeat(numStars, "*");
;;        System.out.print("\n");
;;    }
;;
;;    private void repeat(int numStars, String s) {
;;        for (int i = 0; i < numStars; i++) {
;;            System.out.print(s);
;;        }
;;    }
;;
;;    @Test
;;    public void shouldTree() {
;;        int n = 5;
;;
;;        int maxWidth = (2 * n) - 3;
;;        for (int i = 1; i <= maxWidth; i+=2) {
;;            printLine(maxWidth, i);
;;        }
;;        printLine(maxWidth, 1);
;;    }
