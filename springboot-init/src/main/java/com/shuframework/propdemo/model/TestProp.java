package com.shuframework.propdemo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
//指定文件没什么用
//@PropertySource(value = "classpath:config/dubbo.properties", ignoreResourceNotFound = true)
public class TestProp {
	private String mylog;
//	private String applicationName;

	@Override
	public String toString() {
		return "TestProp [mylog=" + mylog + "]";
	}

	public String getMylog() {
		return mylog;
	}

	public void setMylog(String mylog) {
		this.mylog = mylog;
	}

}
