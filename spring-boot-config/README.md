## Demo project for Spring Cloud Config usage


### Instructions

- update url path for `config-repo` at `spring-cloud-config-server` -> **yaml** file:   

      spring.cloud.config.server.git.uri: ${HOME}/<path to folder>/config-repo
	    
or with absolute path:

    file:/<absolute path to repo>    

- run `spring-cloud-config-server` project
- run `spring-boot-config` project

You can check opening following URLs:

    http://localhost:8888/spring-boot-config/default

    http://localhost:8081/hello
    
    http://localhost:8081/greetings

- update something at the config-repo -> like value for `my.greeting`:`Newly updated value`
- check if it is updated on server:  

      http://localhost:8888/spring-boot-config/default  

- for letting client to know that something was updated call POST request (you can use `HTTP Client` at Intellij):

      POST http://localhost:8081/actuator/refresh  
      Accept: application/json  
      Content-Type: application/json  

- response should be `200`
- open to check that client is updated as well:

      http://localhost:8081/greetings

