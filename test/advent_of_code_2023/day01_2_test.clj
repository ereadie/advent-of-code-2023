(ns advent-of-code-2023.day01-2-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-code-2023.day01-2 :refer [parse-concatenated-digits total-sum]]))

(deftest test-parse-concatenated-digits
  (is (= (parse-concatenated-digits "two1nine") 29))
  (is (= (parse-concatenated-digits "eightwothree") 83))
  (is (= (parse-concatenated-digits "abcone2threexyz") 13))
  (is (= (parse-concatenated-digits "xtwone3four") 24))
  (is (= (parse-concatenated-digits "4nineeightseven2") 42))
  (is (= (parse-concatenated-digits "zoneight234") 14))
  (is (= (parse-concatenated-digits "7pqrstsixteen") 76)))