package com.lk.bussiness;

import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.lk.entity.Allthings_list;

import com.lk.util.C3P0Util;

public class Call_Allthings_list {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public Call_Allthings_list() {
		super();
	}
	
	public List<Allthings_list> findAll() throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		List<Allthings_list> list = qr.query("select * from Allthings_list", new BeanListHandler<Allthings_list>(Allthings_list.class));
		return list;
	}
	
	public Allthings_list findOnebyName(String th_name) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		Allthings_list al = qr.query("select * from Allthings_list where th_name=?", new BeanHandler<Allthings_list>(Allthings_list.class), th_name);
		return al;
	}
	
	public void insertNew(String th_name) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		qr.update("insert into Allthings_list(th_name, th_count)values(?,?)",
				   th_name, 1);
	}
	
	public void th_count_AddOne(String th_name) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		qr.update("update Allthings_list set th_count=th_count+1 where th_name=?", th_name);
	}
	
	public void handleInputName(String th_name) throws SQLException
	{
		Allthings_list al = findOnebyName(th_name);
		
		if(al == null)
		{
			insertNew(th_name);
		}
		else
		{
			th_count_AddOne(th_name);
		}
	}
	
	@Test
	public void test() throws SQLException
	{
		handleInputName("ÀºÇò");
	}

}
