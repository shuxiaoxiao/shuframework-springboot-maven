package com.shuframework.javaeedemo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.shuframework.javaeedemo.filter.AFilter;
import com.shuframework.javaeedemo.filter.MyFilter;

/*
 * 相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan的组合，并具有他们的默认属性值
 * 只能扫描 当前目录和其子目录下的类，所以启动ServletSampleApplication 是访问不到
 * com.shuframework.firstdemo.controller.HelloWorldController 里面的方法
 */
@SpringBootApplication
/*
 * 在SpringBootApplication上使用@ServletComponentScan注解后，
 * Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，
 * 无需其他代码。
 */
//@ServletComponentScan
public class ServletSampleApplication {
	
	//内置了Tomcat 默认端口是8080，通过 main 方法启动项目，在浏览器或其他post 测试工具直接web 访问项目，如http://localhost:8080/hello
	public static void main(String[] args) {
		//修改banner，覆盖该文件即可 /src/main/resources/banner.txt 
		SpringApplication.run(ServletSampleApplication.class, args);
//		HttpEncodingAutoConfiguration
//		//关闭banner
//		SpringApplication app = new SpringApplication(FirstAPP.class);
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
	}
	
//	/**
//	 * 修改DispatcherServlet默认配置
//	 */
//	 @Bean
//	 public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//	   ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//	   //清除请求,默认是"/"
//	   registration.getUrlMappings().clear();
//	   //添加请求拦截
//	   registration.addUrlMappings("*.do");
////	   registration.addUrlMappings("*.json");
//	   return registration;
//	 }
	
	@Bean
	public FilterRegistrationBean authFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(aFilter());
		registration.addUrlPatterns("/*");
//		registration.addInitParameter("paramName", "paramValue");
		registration.setName("aFilter");
		registration.setOrder(Integer.MAX_VALUE-1);

		return registration;
	}
	
	@Bean
	public FilterRegistrationBean myFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(myFilter());
		registration.addUrlPatterns("/*");
//		registration.addInitParameter("paramName", "paramValue");
		registration.setName("myFilter");
		registration.setOrder(Integer.MAX_VALUE-5);

		return registration;
	}


	@Bean(name = "myFilter")
	public Filter myFilter() {
		return new MyFilter();
	}

	@Bean(name = "aFilter")
	public Filter aFilter() {
		return new AFilter();
	}

}
