(ns smallpieces.core)

;; Need to def/alias
;; atom?, car, cdr, boolean?, wrong

(defn evaluate [expr env]
  (if (atom? expr)
    (cond (symbol? expr) (lookup expr env)
          (or (number? expr) (string? expr) (char? expr)
              (boolean? expr) (vector? expr)) expr
          :else (wrong "Can't evaluate" expr))
    (case (car expr)
      ...)))
