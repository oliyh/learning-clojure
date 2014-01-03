(ns learning-clojure.stats)

(defn parse [entry]
  (reduce merge (map (fn [k v] {k v})
                  [:ip :timestamp :method :url :version :response :size]
                  (rest (re-matches #"([^\s]*) \[(.*)\] \"([^\s]*) ([^\s]*) ([^\s]*)\" (\d{3}) (.*)" entry)))))

(defn raw-stats []
  (with-open [rdr (clojure.java.io/reader "resources/epa-http.txt")]
    (doall (map parse (line-seq rdr)))))

(defn unique-visitors []
  (count (group-by :ip (raw-stats)))
  )

(defn failure? [stat]
  (not (= "200" (:response stat)))
  )

(defn no-of-failures []
  (count (filter failure? (raw-stats)))
  )

(defn request-count [entry]
  [(key entry) (count (val entry))]
  )

(defn no-of-failures-by-user []
  (map request-count (group-by :ip (filter failure? (raw-stats))))
  )

(defn most-unlucky-users []
  (take 10 (reverse (sort-by second (no-of-failures-by-user))))
  )

(defn stat-size-as-number [stat]
  (cond
    (= (:size stat) "-")
    0
    (= (:size stat) nil)
    0
    :default (Integer/parseInt (:size stat))
    )
  )

(defn average-response-size []
  (let [sizes (map stat-size-as-number (raw-stats))]
    (double (/ (reduce + sizes) (count sizes)))))