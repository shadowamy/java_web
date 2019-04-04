package cn.lvb.bao;

public class userData implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String IDNumber;
	private String userName;
	private String password;
	private String realname;
	private String Address;
	private int deScore;
	
	public userData() {
		super();
	}

	

	public userData(String iDNumber, String userName, String password, String realname, String address, int deScore) {
		super();
		this.IDNumber = iDNumber;
		this.userName = userName;
		this.password = password;
		this.realname = realname;
		this.Address = address;
		this.deScore = deScore;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		this.IDNumber = iDNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public int getDeScore() {
		return deScore;
	}

	public void setDeScore(int deScore) {
		this.deScore = deScore;
	}
	
	
}
