package com.springboot.rest_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
* Controller - For Spring Boot to know this is a Spring Managed Controller
*
* ResponseBody - When defining RESTful services using Java MVC - return JSON
* The Java Object returned is automatically serialized into JSON
* and passed back in HttpResponse Object
*
* Instead of using above two together
* RestController internally uses both
* */

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello
    // maps HTTP GET request onto specific handler method
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello";
    }

}
