package com.shuframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationConfig {
//	static Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
	
	//按照之前的操作，应该是需要注入sqlSession, 集成了mybatis-spring-boot-starter可以省略,
	//现在的项目集成了mybatisplus，其配置已经移到com.shuframework.config.MybatisPlusConfig类
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }
// 
//    //提供SqlSeesion
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
// 
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
// 
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
// 
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
// 
//        return sqlSessionFactoryBean.getObject();
//    }
// 
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

}
