logpub publishes the local machine's /var/log directory as a local RESTful api

# Use

 1. [install docker](https://docs.docker.com/engine/installation/)
 1. [install docker-compose](https://docs.docker.com/compose/overview/)
 1. run `docker-compose up -d`
 1. currently: load `http://localhost/logs`, future: load `http://localhost` with a tool that can open an HTTP connection and print the response body as plain text (curl recommended)
 1. use the (relative) urls in the supplied [edn](https://github.com/edn-format/edn) list to navigate to load a log file of your choice

# Todo

 1. hateoas from root to `/logs`
 1. error handling
 1. tests
