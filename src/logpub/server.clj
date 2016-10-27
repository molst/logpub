(ns logpub.server
  (:gen-class)
  (:require
   [compojure.core :refer :all]
   [ring.adapter.jetty :as r]
   [clojure.java.io :as io]
   [clojure.pprint :refer [pprint]]))

(defn newer-than [max-age file]
  (and (not (.isDirectory file))
       (<= (- (System/currentTimeMillis)
              (.lastModified file))
           max-age)))

(defn contained-files-newer-than [dir max-age]
  (remove (fn [file]
            (not (newer-than max-age file)))
          (file-seq dir)))

(def week-in-millis 604800000)

(defn filter-dirs
  [& base-uris]
  (for [base-uri base-uris
        file (contained-files-newer-than (io/file base-uri) week-in-millis)]
    (.getPath file)))

(defroutes router
  (GET "/logs" [] (-> "/usr/hostmirror/var/log"
                      filter-dirs
                      pprint
                      with-out-str)))

(defn -main []
  (r/run-jetty #'router {:port 4442}))
