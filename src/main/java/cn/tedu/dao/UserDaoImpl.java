package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.bean.User;
//实例化持久层对象
@Repository
public class UserDaoImpl implements UserDao{
	@Resource
	private DataSource dataSource;
	public User selectByUsername(
			String username) {
		User user = null;
		try {
			//获取连接对象
			Connection conn = 
					dataSource.getConnection();
			//获取预编译对象
			String sql = "select * from t_user"
					   + " where username=?";
			PreparedStatement psm =
					conn.prepareStatement(sql);
			//给？设置值
			psm.setString(1, username);
			//执行
			ResultSet rs = psm.executeQuery();
			//处理结果集
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			rs.close();
			psm.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return user;
	}

}





