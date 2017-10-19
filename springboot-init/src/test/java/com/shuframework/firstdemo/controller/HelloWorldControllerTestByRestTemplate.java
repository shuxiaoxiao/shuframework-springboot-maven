package com.shuframework.firstdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 不推荐，因为测试时需要启动项目和项目的根路径前缀，MockMvc不需要
 * 
 * @author shu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTestByRestTemplate {
	
//	//这个类是spring 内置的，使用@Autowired注入会报错
//	@Autowired
//	private TestRestTemplate restTemplate;

	private TestRestTemplate restTemplate = new TestRestTemplate();
	String basePath = "http://localhost:8080/";

    @Test
    public void getHello_get() throws Exception {
    	String url = basePath + "/hello";
//    	String url = "/hello";
    	String result = restTemplate.getForObject(url, String.class);  
//        Assert.assertTrue("通过主数据的标准化编码进行查询=>测试失败", result.size()>0);  
        System.out.println(result);  
    }
    
    @Test
    public void getHello_post() throws Exception {
    	String url = basePath + "/helloPost";
//    	String url = "/hello";
    	Map map = new HashMap<>();
    	String result = restTemplate.postForObject(url, map, String.class);  
//        Assert.assertTrue("通过主数据的标准化编码进行查询=>测试失败", result.size()>0);  
        System.out.println(result); 
    }

	
}
