package com.shuframework.firstdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTestByMockMvc {

	//模拟mvc
    private MockMvc helloWorldControllerTest;

    @Before
    public void setUp() throws Exception {
        helloWorldControllerTest = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello_get() throws Exception {
        helloWorldControllerTest.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    @Test
    public void getHello_post() throws Exception {
    	MvcResult result = helloWorldControllerTest.perform(MockMvcRequestBuilders.post("/helloPost").accept(MediaType.APPLICATION_JSON_UTF8).content("{}"))
    	.andExpect(MockMvcResultMatchers.status().isOk())
    	.andDo(MockMvcResultHandlers.print())
    	.andReturn();
    	//可通过result.getResponse() 拿到MockHttpServletResponse 对象，然后可以获得其他返回信息。
    	String jsonStr = result.getResponse().getContentAsString();
    	System.out.println("responseJsonString:" + jsonStr);
    }
	
}
