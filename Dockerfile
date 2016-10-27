FROM clojure
RUN mkdir -p /usr/src/logpub
WORKDIR /usr/src/logpub
COPY project.clj /usr/src/logpub/
RUN lein deps
COPY . /usr/src/logpub
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" logpub-standalone.jar
CMD ["java", "-jar", "logpub-standalone.jar"]
