(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "with non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "with zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "with non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "with zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "with truthy value"
    (is (= 5 (harishchandra 5))))
  (testing "with falsy value"
    (is (nil? (harishchandra false))))
  (testing "with falsy value"
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "with truthy value"
    (is (= 5 (yudishtira 5))))
  (testing "with falsy value"
    (is (= :ashwathama (yudishtira false))))
  (testing "with falsy value"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "with a list"
    (is (= `(1 1 2 3 4) (duplicate-first '(1 2 3 4)))))
  (testing "with an vector"
    (is (= [1 1 2 3 4] (duplicate-first [1 2 3 4]))))
  (testing "with an empty list"
    (is (nil? (duplicate-first '()))))
  (testing "with an empty vector"
    (is (nil? (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "when y is 5"
    (is (= :chetan-bhagat (five-point-someone 4 5))))
  (testing "when x is 5"
    (is (= :satan-bhagat (five-point-someone 5 0))))
  (testing "when x is greater than y"
    (is (= :greece (five-point-someone 6 3))))
  (testing "default case"
    (is (= :universe (five-point-someone 4 6)))))

(deftest repeat-and-truncate-test
  (testing "repeat and truncate"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6)))))

(deftest order-in-words-test
  (testing "x>y>z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "z>x>y"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "z>x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-aliases-test
  (testing "zero"
    (is (= :zero (zero-aliases 0))))
  (testing "empty"
    (is (= :empty (zero-aliases []))))
  (testing "empty"
    (is (= :empty (zero-aliases '()))))
  (testing "empty-set"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "empty-map"
    (is (= :empty-map (zero-aliases {}))))
  (testing "empty-string"
    (is (= :empty-string (zero-aliases ""))))
  (testing "not-zero"
    (is (= :not-zero (zero-aliases [2 3])))))

(deftest zero-separated-palindrome-test
  (testing "zero-separated-palindrome"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "zero-separated-palindrome with string"
    (is (= '(:a 4 3 2 0 2 3 4 :a) (zero-separated-palindrome [1 2 3 :a])))))