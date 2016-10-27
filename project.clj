(defproject logpub "0.1.0-SNAPSHOT"
  :description "a /var/log-publishing RESTful service"
  :url "http://www.github.com/molst/logpub"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [compojure "1.5.1"]]
  :source-paths ["src" "test" "dev"]
  :main logpub.server)
