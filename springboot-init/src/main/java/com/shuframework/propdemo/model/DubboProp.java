package com.shuframework.propdemo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dubbo")
//指定文件没什么用
//@PropertySource(value = "classpath:config/dubbo.properties", ignoreResourceNotFound = true)
public class DubboProp {
	private String username;
	private String applicationName;

	
	@Override
	public String toString() {
		return "DubboProp [username=" + username + ", applicationName=" + applicationName + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
