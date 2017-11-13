package com.shuframework.firstdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    	return "Hello World, @RequestMapping-get请求";
    }
    
    @GetMapping(value = "/helloGet2")
    public String helloGet2() {
    	return "Hello World, @GetMapping请求";
    }
    
    //请求路径http://localhost:8080/helloGetHasParam?name=中国
    @RequestMapping(value = "/helloGetHasParam", method = RequestMethod.GET)
    public String helloGetHasParam(String name) {
    	return "Hello World, @RequestMapping-get请求, 参数" + name;
    }
    
    /*
     * 请求路径http://localhost:8080/helloGetHasParam/中国  或 http://localhost:8080/helloGetHasParam/{"pa":"aa","pb":"中国"}
     * 报异常：The valid characters are defined in RFC 7230 and RFC 3986 
     * 原因：RFC 3986文档规定，Url中只允许包含英文字母（a-z，A-Z）、数字（0-9）、- _ . ~ 4个特殊字符以及所有保留字符。
     * 解决方法：改为上面的那种get
     */
    @RequestMapping(value = "/helloGetHasParam2/{name}", method = RequestMethod.GET)
    public String helloGetHasParam2(@PathVariable String name) {
    	return "Hello World, @RequestMapping-get请求, 参数" + name;
    }
    
    @RequestMapping(value = "/helloPost", method = RequestMethod.POST)
    public String helloPost() {
    	return "Hello World, @RequestMapping-post请求";
    }
    
    @PostMapping(value = "/helloPost2")
    public String helloPost2() {
    	return "Hello World, @PostMapping请求";
    }
    
    @RequestMapping(value = "/helloPostHasParam", method = RequestMethod.POST)
    public String helloPostHasParam(String name) {
    	return "Hello World, @RequestMapping-post请求, 参数" + name;
    }
    
    @PostMapping(value = "/helloPost2HasParam")
    public String helloPost2HasParam(String name) {
    	return "Hello World, @PostMapping请求, 参数" + name;
    }
    
}