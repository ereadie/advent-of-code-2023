(ns advent-of-code-2023.core
  (:require [clojure.string :as string])
  (:gen-class))

(defn parse-digits-sum [line]
  (println "Input string:" line)
  (let [digit-pattern #"\d"
        digit-matches (re-seq digit-pattern line)]
    (println "Digit matches:" digit-matches)
    (let [match-count (count digit-matches)]
      (println "Match count:" match-count)
      (if (= match-count 0)
        0
        (if (= match-count 1)
          (let [result (str (first digit-matches) (first digit-matches))]
            (println "Concatenating single match:" result)
            (Integer/parseInt result))
          (let [result (str (first digit-matches) (last digit-matches))]
            (println "Concatenating first and last match:" result)
            (Integer/parseInt result)))))))

(defn calculate-total-sum [lines]
  (reduce (fn [total line]
            (+ total (parse-digits-sum line)))
          0
          lines))

(defn -main [& args]
  (let [input (slurp "./data/input_day1_1.txt")
        lines (string/split input #"\r?\n")
        total-sum (calculate-total-sum lines)]
    (println "Total sum of first and last digits:" total-sum)))
