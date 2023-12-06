(ns advent-of-code-2023.day01-1
  (:require [clojure.string :as string]))

(defn parse-digits-sum [line]
  (let [digit-pattern #"\d"
        digit-matches (re-seq digit-pattern line)]
    (Integer/parseInt  (str (first digit-matches) (last digit-matches)))))

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


