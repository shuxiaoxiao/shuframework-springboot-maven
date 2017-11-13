package com.shuframework.javaeedemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
	
	@Override
    public void contextDestroyed(ServletContextEvent arg0) {

        System.out.println("ServletContex销毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        System.out.println("ServletContex初始化");
    }
}
