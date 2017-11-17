package com.shuframework.propdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收单个值
 * @author shu
 *
 */
@RestController
@PropertySource(value = "classpath:config/dubbo.properties", ignoreResourceNotFound = true)
//@PropertySource(value = {"classpath:jdbc.properties","classpath:config/dubbo.properties"}, ignoreResourceNotFound = true)
public class PropValueController {

	@Value("${dubbo.application.name}")
	private String dname;

	@RequestMapping("/testValueProp")
	public String testClassProp() {
		return "hello world, dname: " + dname;
	}
}
