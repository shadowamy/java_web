package cn.lk.entity;

public class ContactMsg {

    private String Name;
    private String Phonenumber;
    private String Address;
    private String BelongUSer;


    public ContactMsg(String name, String phonenumber, String address, String belongUSer) {
		super();
		Name = name;
		Phonenumber = phonenumber;
		Address = address;
		BelongUSer = belongUSer;
	}

	public ContactMsg() {
    }

    public String getName() {
        return Name;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

	public String getBelongUSer() {
		return BelongUSer;
	}

	public void setBelongUSer(String belongUSer) {
		BelongUSer = belongUSer;
	}
    
    
}
