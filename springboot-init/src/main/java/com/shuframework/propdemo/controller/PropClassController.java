package com.shuframework.propdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shuframework.propdemo.model.DubboProp;
import com.shuframework.propdemo.model.TestProp;

/**
 * 接收一个类型的所有值
 * @author shu
 *
 */
@RestController
// 可以替代@Component的作用，个人更偏向@Component来注入
// @EnableConfigurationProperties({DubboProp.class})
public class PropClassController {

	@Autowired
	private DubboProp dubboProp;
	@Autowired
	private TestProp testProp;

	@RequestMapping("/testClassProp")
	public String testClassProp() {
//		return "hello world, dname: " + dubboProp.getUsername() + ", appname: " + dubboProp.getApplicationName();
		//DubboProp类重写了tostring
		return "hello world, dubboProp: " + dubboProp;
	}
	
	@RequestMapping("/testClassProp2")
	public String testClassProp2() {
		//TestProp类重写了tostring
		return testProp.toString();
	}
}
