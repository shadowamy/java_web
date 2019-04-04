package com.lk.exe;

import java.io.IOException;
import java.io.InputStream;
//import java.io.OutputStream;

import java.net.Socket;
import java.sql.SQLException;

import org.junit.Test;

public class SocketImgResult {

	public static String img_result()
	
	{
		try {
			
			Socket socket = new Socket("localhost",12345);

			InputStream in = socket.getInputStream();
	        byte[] buf = new byte[1024];

	        int len = in.read(buf);
	        String text = "";
	        
	        text = new String(buf, 0, len);
	        if(text.equals("data_lack"))
	        {
	        	text = "";
	        }
	        System.out.println(text);

	        socket.close();
			
	        return text;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void test() throws SQLException
	{
		img_result();
	}
	
}