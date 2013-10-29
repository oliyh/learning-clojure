(ns learning-clojure.core
  (:require [cheshire.core :refer :all]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn hello []
  (println "Hello, World!"))

(defn load-recipes-json []
  (parse-string (slurp "resources/recipes.json") true))
