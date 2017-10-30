package com.shuframework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component //这样设置后就会当做对象 一开始创建加载
//@EnableConfigurationProperties(TestProp.class) //在需要注入的位置引入
@ConfigurationProperties(prefix = "test")
public class TestProp {

	private String mylog;

	public String getMylog() {
		return mylog;
	}

	public void setMylog(String mylog) {
		this.mylog = mylog;
	}
	
}
