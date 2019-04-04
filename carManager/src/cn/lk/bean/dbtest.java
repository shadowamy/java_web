package cn.lk.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import cn.lk.util.C3P0Util;
import cn.lvb.bao.userData;
import cn.lvb.bao.violationData;


public class dbtest {
	
	
	DataSource ds = C3P0Util.getDataSource();
	QueryRunner qr = new QueryRunner(ds);
	
	@Test
	public void test2() throws SQLException{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		//violationData vio = qr.query("select * from userdata where username=?", new BeanHandler<violationData>(violationData.class), id);
		qr.update("insert into userdata(idnumber, username, password, realname, address, descore)values(?,?,?,?,?,?)",
				"371122199802125456", "ssr3", "111", "王明", "杭州阿里", 3);
	}

}
