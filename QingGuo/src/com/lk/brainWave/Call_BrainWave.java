package com.lk.brainWave;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.lk.util.C3P0Util;

public class Call_BrainWave {

	public DataSource ds = null;
	public QueryRunner qr = null;
	
	public Call_BrainWave() {
		super();
	}
	
	public BrainWave getLastWave() throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		BrainWave bw = qr.query("select * from eeg order by id desc limit 1", new BeanHandler<BrainWave>(BrainWave.class));
		return bw;
	}
	
	@Test
	public void test() throws SQLException
	{
		BrainWave lw = getLastWave();
		System.out.println(lw.getAttention());
	}
	
}
