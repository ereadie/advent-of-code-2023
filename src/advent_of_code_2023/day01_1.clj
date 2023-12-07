(ns advent-of-code-2023.day01-1
  (:require [clojure.string :as string]))

(defn parse-concatenated-digits
  [line]
  (let [digit-pattern #"\d"
        digit-matches (re-seq digit-pattern line)]
    (if (seq digit-matches)
      (let [first-digit (first digit-matches)
            last-digit (or (last digit-matches) first-digit)]
        (Integer/parseInt (str first-digit last-digit)))
      0)))

(defn total-sum
  [lines]
  (reduce + (map parse-concatenated-digits lines)))

(defn read-input-lines
  [file-path]
  (string/split (slurp file-path) #"\r?\n"))

(defn -main [& args]
  (let [lines (read-input-lines "./data/day01_1.txt")
        total (total-sum lines)]
    (println "Total sum of concatenated first and last digits:" total)))
