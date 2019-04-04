package cn.lk.bean;

import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.lk.util.C3P0Util;
import cn.lvb.bao.userData;

public class call_userDataDB {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public call_userDataDB() {
		super();
	}
	
	public userData findByUsername(String username) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		userData user = qr.query("select * from userdata where username=?", new BeanHandler<userData>(userData.class), username);
		//System.out.println(user);
		return user;
		
	}
	
	public userData findByidNum(String idNum) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		userData user = qr.query("select * from userdata where idnumber=?", new BeanHandler<userData>(userData.class), idNum);
		//System.out.println(user);
		return user;
		
	}
	
	public void insertUserdata(userData ud) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("insert into userdata(idnumber, username, password, realname, address, descore)values(?,?,?,?,?,?)",
				   ud.getIDNumber(),ud.getUserName(), ud.getPassword(),ud.getRealname(),ud.getAddress(), ud.getDeScore());
	}
	
	public void update_deScore(String idNum, int newScore) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("update userdata set deScore=? where idnumber=?", newScore,idNum);
	}
	
	@Test
	public void test() throws SQLException
	{
		//userData user = findByidNum("371155698545699988");
		//System.out.println(user.getIDNumber());
		userData ud = new userData("371122199802125456", "ssr3", "111", "王明", "杭州阿里", 3);
		insertUserdata(ud);
	}
	
}
