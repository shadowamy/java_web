package cn.lk.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.lk.util.C3P0Util;
import cn.lvb.bao.userData;
import cn.lvb.bao.violationData;

public class call_violationDataDB {

	public DataSource ds = null;
	public QueryRunner qr = null;
	public call_violationDataDB() {
		super();
	}
	
	public List<violationData> findByIDNumber(String id) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		//violationData vio = qr.query("select * from userdata where username=?", new BeanHandler<violationData>(violationData.class), id);
		List<violationData> list = qr.query("select * from violationdata where idnumber=?", new BeanListHandler<violationData>(violationData.class),id);
		return list;
		
	}
	
	public List<violationData> findAll() throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		//violationData vio = qr.query("select * from userdata where username=?", new BeanHandler<violationData>(violationData.class), id);
		List<violationData> list = qr.query("select * from violationdata", new BeanListHandler<violationData>(violationData.class));
		return list;
		
	}
	
	public violationData findByvioID(String vioID) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		violationData vd = qr.query("select * from violationdata where vioid=?", new BeanHandler<violationData>(violationData.class), vioID);
		return vd;
		
	}
	
	public void update_vioStatus(int vioID, String vioStatus) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("update violationdata set viostatus=? where vioID=?", vioStatus,vioID);
	}
	
	public void insertViolationdata(violationData vd) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("insert into violationdata(carnumber, vioTime, vioContent, Penalty, vioScore, viostatus, idnumber)values(?,?,?,?,?,?,?)",
				   vd.getCarNumber(),vd.getVioTime(),vd.getVioContent(),vd.getPenalty(),vd.getVioScore(),vd.getVioStatus(),vd.getIDNumber());
	}
	
	public void delByVioID(int vioid) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		
		qr.update("delete from violationdata where vioid=?", vioid);
	}
	
	
	public void update_All(int vioID, String carNumber, Date vioTime, String vioContent, double Penalty, int vioScore, String vioStatus, String idNumber) throws SQLException
	{
		ds = C3P0Util.getDataSource();
		qr = new QueryRunner(ds);
		qr.update("update violationdata set carnumber=?, viotime=?, viocontent=?, penalty=?, vioscore=?, viostatus=?, idnumber=? where vioID=?",
				carNumber, vioTime, vioContent, Penalty, vioScore, vioStatus, idNumber, vioID);
	}
	
	@Test
	public void test() throws SQLException
	{
		/*List<violationData> list = findAll();
		for(violationData i:list)
		{
			System.out.println(i.getVioContent());
		}*/
		/*violationData vd = new violationData(0, "331122xxxxxxxx", "Â³c test", new Date(), "×í¾Æ¼ÝÊ»", 1200,
				12, "Î´´¦Àí");
		insertViolationdata(vd);*/
		
		//delByVioID(4);
		update_All(22, "test1122", new Date(), "445566", 50.0, 1, "already", "3322144556");
		
	}
}
