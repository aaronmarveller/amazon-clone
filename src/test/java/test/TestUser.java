package test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDaoImpl;
import cn.tedu.service.UserService;

public class TestUser {
	@Test
	public void testSelectByUsername(){
		//1.获取容器对象
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		//2.获取bean对象
		UserDaoImpl userDao = 
				ac.getBean("userDaoImpl",
						UserDaoImpl.class);
		//3.调用方法
		System.out.println(
			userDao.selectByUsername("admin1"));
	
	}
	@Test
	public void testLogin(){
		//1.
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"application-dao.xml",
					"application-service.xml");
		UserService us = 
			ac.getBean("userServiceImpl",
					UserService.class);
		System.out.println(
				us.login("admin", "12345"));
	}

}








