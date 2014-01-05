(ns learning-clojure.app
  (:require [ring.middleware.json :as ring-json]
            [compojure.handler :as handler]
            [compojure.core
             :as c-core
             :refer [defroutes GET POST PUT DELETE HEAD OPTIONS PATCH ANY]]
            [compojure.route :as c-route]
            [learning-clojure.stats :as stats]))

(defroutes api
  (GET "/" [] "Hello world")
  (GET "/raw" [] (take 5 (stats/raw-stats))))

(defroutes defaults
  (c-route/resources "/")
  (c-route/not-found "404 Page not found."))

(def app (c-core/routes api defaults))

(defn get-handler []
  (-> (handler/api app)
      (ring-json/wrap-json-body {:keywords? true})
      (ring-json/wrap-json-response)))
