(ns learning-clojure.stats)

(defn parse [entry]
  (reduce merge (map (fn [k v] {k v})
                  [:ip :timestamp :method :url :version :response :size]
                  (rest (re-matches #"([^\s]*) \[(.*)\] \"([^\s]*) ([^\s]*) ([^\s]*)\" (\d{3}) (.*)" entry)))))

(defn raw-stats []
  (with-open [rdr (clojure.java.io/reader "resources/epa-http.txt")]
    (doall (map parse (line-seq rdr)))))