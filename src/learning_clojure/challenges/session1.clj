(ns learning-clojure.challenges.session1
  (:use [clojure.math.numeric-tower]))

(defn sum-all [s]
  (reduce + s))

(defn problem-2
  "2. Calculate the sum of [1 2 3 4 5 ... 100]"
  [] (sum-all (range 1 100)))

(defn divisible-by? [x]
  (fn [y] (zero? (rem y x))))

(defn problem-3
  "Create a list of all the numbers divisible by 3 in the range [1 2 3 4 5 ... 100]"
  [] (filter (divisible-by? 3) (range 1 100)))

(def people [{:name "Frodo" :age 44}
             {:name "Toto" :age 58}
             {:name "Bono" :age 52}
             {:name "Hans Solo" :age 28}
             {:name "Marco Polo" :age 259}])

(defn problem-4
  "Create a list of the names of people"
  [] (map :name people))

(defn problem-5
  "5. Create a list with the year of people's births"
  [] (map #(- 2013 (:age %)) people))