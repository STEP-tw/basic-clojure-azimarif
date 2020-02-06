(ns assignments.util)

(defn implemented? [f]
  (-> f resolve meta :implemented?))

(defn insert-println-if-implemented [form]
  (let [f (first form)]
    (when (and (resolve f) (implemented? f))
      (list '(println "---")
            `(println "Running: " '~form)
            `(println "Result:  " ~form)))))

(defmacro print-and-do [& forms]
  (let [forms-with-println (mapcat insert-println-if-implemented forms)]
    (list* 'do forms-with-println)))

(defn increment [value]
  (if (instance? Number value)
    (inc value)
    value))

(defn is-divisible [dividend divisor] (zero? (mod dividend divisor)))

(defn de-duplicate [coll number]
  (cond
    (empty? coll) (vector number)
    (not= number (last coll)) (conj coll number)
    :else coll))