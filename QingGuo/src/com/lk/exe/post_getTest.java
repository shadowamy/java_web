package com.lk.exe;

import com.lk.util.Http_messageRequest;

public class post_getTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "Æ»¹û";
		//System.out.println(name);
        //String s=Http_messageRequest.sendPost("http://localhost:8080/QingGuo/Qbject_nameRequest", "key="+name);
        
        String s=Http_messageRequest.sendPost("http://localhost:8080/AddressBookWeb/AllContactServlet", "BelongUser="+"123");
        
        
        
        System.out.println(s);
		
	}

}
