package cn.lk.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.lk.entity.ContactMsg;
import cn.lk.entity.User;
import cn.lk.util.C3P0Util;

public class CallContactMsg {

	public static DataSource ds = C3P0Util.getDataSource();
	public static QueryRunner qr = new QueryRunner(ds);
	
	public static List<ContactMsg> findByBelongUser(String belonguser) throws SQLException
	{
		List<ContactMsg> list = qr.query("select * from ContactMsg where BelongUser=?", new BeanListHandler<ContactMsg>(ContactMsg.class),belonguser);
		return list;
	}
	
	public static ContactMsg findSingleDetails(String belonguser, String phonenumber)
	{
		ContactMsg contactMsg = null;
		
		try {
			contactMsg = qr.query("select * from ContactMsg where BelongUser=? and Phonenumber=?", new BeanHandler<ContactMsg>(ContactMsg.class), belonguser, phonenumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contactMsg;
		
	}
	
	public static void addOneContact(ContactMsg contactMsg)
	{
		try {
			qr.update("insert into ContactMsg(Name, Phonenumber, Address, BelongUser)values(?,?,?,?)",
					   contactMsg.getName(), contactMsg.getPhonenumber(), contactMsg.getAddress(), contactMsg.getBelongUSer());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteOneContact(ContactMsg contactMsg)
	{
		try {
			qr.update("delete from ContactMsg where BelongUser=? and Phonenumber=?", contactMsg.getBelongUSer(), contactMsg.getPhonenumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateOneContact(ContactMsg oldcon, ContactMsg newcon)
	{
		try {
			qr.update("update ContactMsg set Name=?, Phonenumber=?, Address=? where BelongUser=? and Phonenumber=?", 
					   newcon.getName(), newcon.getPhonenumber(), newcon.getAddress(), oldcon.getBelongUSer(), oldcon.getPhonenumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<ContactMsg> fuzzyQuery(String belonguser, String enterStr)
	{
		List<ContactMsg> list = null;
		try {
			list = qr.query("select * from ContactMsg where BelongUser=? and name like ?", new BeanListHandler<ContactMsg>(ContactMsg.class),belonguser, '%'+enterStr+'%');
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Test
	public void test() throws SQLException
	{
		List<ContactMsg> l = fuzzyQuery("123", "三");
		for(ContactMsg i:l)
		{
			System.out.println(i.getName());
		}
	}
	
}
