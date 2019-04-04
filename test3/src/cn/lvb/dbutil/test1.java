package cn.lvb.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


public class test1 {

	@Test
	public void ttt1() throws Exception
	{
		String sql = "select name from student";
		
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
	}
}
