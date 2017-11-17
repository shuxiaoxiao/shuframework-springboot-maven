package com.shuframework.firstdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 推荐，可以不用启动项目就能执行脚本
 * @author shu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTestByMockMvc {

	//模拟mvc
    private MockMvc mockMvc;
    
    @Autowired
    private HelloWorldController helloWorldController;
    
    @Autowired
    private WebApplicationContext wac;

    //MockMvcBuilders构建MockMvc对象，本测试类是测试单个controller，不用注入所有项目
    @Before
    public void setUp() throws Exception {
    	//注入WebApplicationContext，创建所有项目对象（集成Web环境测试，项目拦截器有效）
//    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    	
//    	//采用@Autowired创建controller里面的注解对象都被创建 （单个类测试，拦截器无效）,
//    	//度取不到application.properties文件
    	mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
//    	//采用new 创建controller里面的注解对象都是null，如userService
//    	mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build(); 
    }

    @Test
    public void getHello_get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    @Test
    public void getHello_post() throws Exception {
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/helloPost").accept(MediaType.APPLICATION_JSON_UTF8).content("{}"))
    	.andExpect(MockMvcResultMatchers.status().isOk())
    	.andDo(MockMvcResultHandlers.print())
    	.andReturn();
    	//可通过result.getResponse() 拿到MockHttpServletResponse 对象，然后可以获得其他返回信息。
    	String jsonStr = result.getResponse().getContentAsString();
    	System.out.println("responseJsonString:" + jsonStr);
    }
	
}
