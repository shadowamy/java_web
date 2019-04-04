package cn.lvb.bao;

import java.util.Date;

public class violationData implements java.io.Serializable{

	private static final long serialVersionUID = 2L;
	private int vioID;
	private String IDNumber;
	private String carNumber;
	private Date vioTime;
	private String vioContent;
	private double Penalty;
	private int vioScore;
	private String vioStatus; 

	
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public violationData(int vioID, String iDNumber, String carNumber, Date vioTime, String vioContent, double penalty,
			int vioScore, String vioStatus) {
		super();
		this.vioID = vioID;
		this.IDNumber = iDNumber;
		this.carNumber = carNumber;
		this.vioTime = vioTime;
		this.vioContent = vioContent;
		Penalty = penalty;
		this.vioScore = vioScore;
		this.vioStatus = vioStatus;
	}

	public violationData() {
		super();
	}

	public int getVioID() {
		return vioID;
	}


	public void setVioID(int vioID) {
		this.vioID = vioID;
	}
	
	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		this.IDNumber = iDNumber;
	}

	
	public Date getVioTime() {
		return vioTime;
	}
	public void setVioTime(Date vioTime) {
		this.vioTime = vioTime;
	}
	public String getVioContent() {
		return vioContent;
	}
	public void setVioContent(String vioContent) {
		this.vioContent = vioContent;
	}
	public double getPenalty() {
		return Penalty;
	}
	public void setPenalty(double penalty) {
		Penalty = penalty;
	}
	public int getVioScore() {
		return vioScore;
	}
	public void setVioScore(int vioScore) {
		this.vioScore = vioScore;
	}

	public String getVioStatus() {
		return vioStatus;
	}

	public void setVioStatus(String vioStatus) {
		this.vioStatus = vioStatus;
	}
	
	
	
}
