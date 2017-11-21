package com.shuframework;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@SpringBootApplication(scanBasePackages= {"com.shuframework"})
@SpringBootApplication
@MapperScan("com.shuframework.*.dao")
//@ConfigurationProperties(prefix="spring.datasource")//默认就是这个开头
public class Application {
	static Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
//		log.info("=== 开启 ===");//打印不出来
		SpringApplication.run(Application.class, args);
		log.info("=== 结束 ===");
	}
}
