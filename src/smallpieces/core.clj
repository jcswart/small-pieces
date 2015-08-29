(ns smallpieces.core)

(def car first)
(def cdr last)

(defn wrong
  [msg v]
  (throw (ex-info msg {:data v})))

(defn boolean?
  [x]
  (or (= true x) (= false x)))

(defn atom?
  [x]
  (let [pair? (fn [x]
                (or (= (type x) clojure.lang.Cons)
                    (list? x)))]
    (and (not (pair? x))
         (not (nil? x)))))

(defn lookup
  [e env]
  (println e env) e)

(defn evaluate [e env]
  (if (atom? e)
    (cond (symbol? e)      (lookup e env)
          (or (number?  e)
              (string?  e)
              (char?    e)
              (boolean? e)
              (vector?  e)) e
          :else (wrong "Can't evaluate" e))
    (case (car e)
      e)
    ))
