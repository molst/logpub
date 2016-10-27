(ns logpub.server
  (:gen-class)
  (:require
   [compojure.core :refer :all]
   [ring.adapter.jetty :as r]))

(defroutes router
  (GET "/" [] "this is not a list of options"))

(defn -main []
  (r/run-jetty #'router {:port 4442}))
