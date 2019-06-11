package cn.lk.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.lk.entity.User;
import cn.lk.util.C3P0Util;

public class CallUser {

	public static DataSource ds = C3P0Util.getDataSource();
	public static QueryRunner qr = new QueryRunner(ds);
	
	public static User findByUsername(String Username)
	{
		User user = null;
		
		try {
			user = qr.query("select * from User where username=?", new BeanHandler<User>(User.class), Username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static void addNewUser(User user)
	{
		try {
			qr.update("insert into User(Username, Password)values(?,?)",
					   user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() throws SQLException
	{
		User user = new User("156", "120");
		addNewUser(user);
	}
}
