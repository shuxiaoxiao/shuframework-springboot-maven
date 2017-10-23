package com.shuframework;

import org.mybatis.spring.annotation.MapperScan;
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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
