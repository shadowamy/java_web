package com.lk.bussiness;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.lk.entity.Allthings_list;
import com.lk.entity.Things_record;

import com.lk.util.C3P0Util;


public class Call_Things_records {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public Call_Things_records() {
		super();
	}
	
	public List<Things_record> findAll() throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		List<Things_record> list = qr.query("select * from Things_record", new BeanListHandler<Things_record>(Things_record.class));
		return list;
	}
	
	public List<Things_record> findLatest() throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		String sql = "select * from things_record where (re_id in (SELECT MAX(re_id) FROM things_record " + 
				     "GROUP BY re_name))";
		List<Things_record> list = qr.query(sql, new BeanListHandler<Things_record>(Things_record.class));
		return list;
		
	}
	
	public Things_record findLatestOne(String name) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		String sql = "select * from things_record where (re_id in (SELECT MAX(re_id) FROM things_record " + 
				     "GROUP BY re_name) and re_name=?)";
		Things_record tr = qr.query(sql, new BeanHandler<Things_record>(Things_record.class), name);
		return tr;
		
	}
	
	public void insertOne(Things_record tr) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("insert into Things_record(re_name, re_time)values(?,?)",
				   tr.getRe_name(), tr.getRe_time());
	}
	
	public void insertOneByName(String name) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("insert into Things_record(re_name, re_time)values(?,?)",
				   name, new Date());
	}
	
	@Test
	public void test() throws SQLException
	{
		/*List<Things_record> findAll = findAll();
		System.out.println(findAll);*/
		/*Date d = new Date();
		Things_record tr = new Things_record(0, "×ãÇò", d);
		insertOne(tr);*/
		//insertOneByName("ÀºÇò");
		/*List<Things_record> list = findLatest();
		for(Things_record a : list)
		{
			System.out.println(a.getRe_id());
		}*/
		Things_record l = findLatestOne("ÊÖ»ú");
		System.out.println(l.getRe_id());
	}
	
}
