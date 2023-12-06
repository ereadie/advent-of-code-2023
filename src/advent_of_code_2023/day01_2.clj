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
    (Integer/parseInt input)))

(defn parse-digits-sum [line]
  (let [digit-pattern #"\d|one|two|three|four|five|six|seven|eight|nine"
        digit-matches (re-seq digit-pattern line)]
    (println "Line: " line)
    (println "Digit Pattern: " digit-pattern)
    (println "Digit Matches: " digit-matches)
    (println "First Digit Match: " (first digit-matches))
    (println "Last Digit Match: " (last digit-matches))
    (println "Parsed First Digit Match: " (parse-match (first digit-matches)))
    (println "Parsed Last Digit Match: " (parse-match (last digit-matches)))
    (Integer/parseInt (str (parse-match (first digit-matches))
                           (parse-match (last digit-matches))))))

(defn calculate-total-sum [lines]
  (reduce (fn [total line]
            (+ total (parse-digits-sum line)))
          0
          lines))

(defn -main [& args]
  (let [input (slurp "./data/day01_1.txt")
        lines (string/split input #"\r?\n")
        total-sum (calculate-total-sum lines)]
    (println "Total sum of first and last digits:" total-sum)))