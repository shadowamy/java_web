package cn.lk.bean;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.lk.util.C3P0Util;
import cn.lvb.bao.adminUser;


public class call_adminuserDataDB {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public call_adminuserDataDB() {
		super();
	}
	
	public adminUser findByUsername(String username) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		adminUser user = qr.query("select * from adminuser where username=?", new BeanHandler<adminUser>(adminUser.class), username);
		//System.out.println(user);
		return user;
		
	}
	
	@Test
	public void test() throws SQLException
	{
		//userData user = findByidNum("371155698545699988");
		//System.out.println(user.getIDNumber());
		adminUser user = findByUsername("root");
		System.out.println(user.getRealname());
	}
	
	
}
