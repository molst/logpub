logpub publishes the local machine's /var/log directory as a local RESTful api

# Use

 1. [install docker](https://docs.docker.com/engine/installation/)
 1. [install docker-compose](https://docs.docker.com/compose/overview/)
 1. run `docker-compose up -d` (future feature) OR `docker build -t logpub:latest` and `docker run -p 80:4442 logpub` from the root dir of this repo
 1. load `http://localhost` with a tool that can open an HTTP connection and print the response body as plain text (such as a browser or curl)
 1. use the urls in the supplied [edn](https://github.com/edn-format/edn) value to navigate to the log file of your choice

# Develop

 TBD
