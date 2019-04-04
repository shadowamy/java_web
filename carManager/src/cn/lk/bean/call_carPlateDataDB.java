package cn.lk.bean;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.lk.util.C3P0Util;
import cn.lvb.bao.carPlateData;

import org.junit.Test;

public class call_carPlateDataDB {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public call_carPlateDataDB() {
		super();
	}

	public List<carPlateData> findByLicenseID(String id) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		//carPlateData vio = qr.query("select * from userdata where username=?", new BeanHandler<carPlateData>(carPlateData.class), id);
		List<carPlateData> list = qr.query("select * from carPlateData where licenseid=?", new BeanListHandler<carPlateData>(carPlateData.class),id);
		return list;
		
	}
	
	@Test
	public void test() throws SQLException
	{
		List<carPlateData> list = findByLicenseID("371155698545699988");
		for(carPlateData c:list)
		{
			System.out.println(c.getCarNumber());
		}
	}
	
}
