(ns advent-of-code-2023.day01-2
  (:require [clojure.string :as string]))

(defn parse-match [input]
  (case input
    "one" 1
    "two" 2
    "three" 3
    "four" 4
    "five" 5
    "six" 6
    "seven" 7
    "eight" 8
    "nine" 9
    (try
      (Integer/parseInt input)
      (catch NumberFormatException e
        0))))

(defn parse-concatenated-digits
  [line]
  (let [digit-pattern #"\d|one|two|three|four|five|six|seven|eight|nine"
        digit-matches (re-seq digit-pattern line)]
    (if (seq digit-matches)
      (let [first-digit (first digit-matches)
            last-digit (or (last digit-matches) first-digit)]
        (Integer/parseInt (str (parse-match first-digit) (parse-match last-digit))))
      (Integer/parseInt "0"))))

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
