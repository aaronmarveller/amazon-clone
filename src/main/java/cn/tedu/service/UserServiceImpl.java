package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.bean.User;
import cn.tedu.dao.UserDao;
@Service
public class UserServiceImpl implements 
		UserService{
	@Resource
	private UserDao userDao;
	public User login(String username, String pwd) {
		//1.调用持久的方法；返回user对象
		User user = 
				userDao.selectByUsername(username);
		//2.
		if(user==null){
			throw new RuntimeException("用户名错误");
		}else{
		//3.如果存在；判断密码
			if(user.getPassword().equals(pwd)){
			//4.如果密码相同，返回user对象
				return user;
			}else{
			//5.密码不相同，抛出异常
				throw new RuntimeException("密码错误");
			}
		}
	}

}




