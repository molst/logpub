logpub publishes the local machine's /var/log directory as a local RESTful api

# Use

 1. [install docker](https://docs.docker.com/engine/installation/)
 1. [install docker-compose](https://docs.docker.com/compose/overview/)
 1. run `docker-compose up -d`
 1. currently: load `http://localhost/logs`, future: load `http://localhost` with a tool that can open an HTTP connection and print the response body as plain text (such as a browser or curl)
 1. use the urls in the supplied [edn](https://github.com/edn-format/edn) value to navigate to the log file of your choice

# Develop

 TBD
