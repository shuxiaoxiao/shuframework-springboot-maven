package com.shuframework.firstdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
    
    @RequestMapping(value = "/helloGet", method = RequestMethod.GET)
    public String helloGet() {
    	return "Hello World, get请求";
    }
    
    @RequestMapping(value = "/helloPost", method = RequestMethod.POST)
    public String helloPost() {
    	return "Hello World, post请求";
    }
    
}