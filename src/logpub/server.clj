(ns logpub.server
  (:gen-class)
  (:require
   [compojure.core :refer :all]
   [ring.adapter.jetty :as r]
   [ring.util.response :refer [response file-response]]
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
(def log-location "/usr/hostmirror/var/log/")

(defn filter-dirs
  [& base-uris]
  (for [base-uri base-uris
        file (contained-files-newer-than (io/file base-uri) week-in-millis)]
    (.getPath file)))

(defn replace-prefix [strings prefix replacement]
  (for [s strings]
    (clojure.string/replace s prefix replacement)))

(defroutes router
  (GET "/logs" []
       (-> log-location
           filter-dirs
           (replace-prefix log-location "logs/")
           pprint
           with-out-str))
  (GET "/logs/:file-ref{.+}" [file-ref]
       (let [file (io/file (str log-location file-ref))]
         (if (.exists file)
           (file-response (str log-location file-ref))
           {:status 404
            :body "file not found"}))))

(defn -main []
  (r/run-jetty #'router {:port 4442}))
