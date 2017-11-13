package com.shuframework.firstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan的组合，并具有他们的默认属性值
public class FirstAPP {
	
	//内置了Tomcat 默认端口是8080，通过 main 方法启动项目，在浏览器或其他post 测试工具直接web 访问项目，如http://localhost:8080/hello
	public static void main(String[] args) {
		//修改banner，覆盖该文件即可 /src/main/resources/banner.txt 
		SpringApplication.run(FirstAPP.class, args);
//		HttpEncodingAutoConfiguration
//		//关闭banner
//		SpringApplication app = new SpringApplication(FirstAPP.class);
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
	}

}
