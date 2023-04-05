package com.cav.springboot.restapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {

    @RequestMapping("/helloworld")
    //@ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/helloworldbean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @RequestMapping("/helloworld-path-param/{name}/{message}")
    public HelloWorldBean helloWorldPathParam(@PathVariable String name, @PathVariable String message) {
        return new HelloWorldBean("Hello World, " + name + " , " + message);
    }

}
