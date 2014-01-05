(ns learning-clojure.server
  (:require [learning-clojure.app :as app]
            [ring.server.standalone :as ring-server]))

(defn start-server
  "used for starting the server in development mode from REPL, e.g. (def server (start-server))"
  []
  (let [port 8080
        server (ring-server/serve (app/get-handler)
                                  {:port port
                                   :auto-reload? true
                                   :join true
                                   :open-browser? false})]
    (println (str "You can view the site at http://localhost:" port "/"))
    server))
