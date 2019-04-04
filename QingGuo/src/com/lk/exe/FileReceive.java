package com.lk.exe;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;



public class FileReceive {

	
	private Socket socket;
	private DataInputStream dis;  
    private FileOutputStream fos;  

	
	public FileReceive(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void doReceive()
	{
		try {
			
			 dis = new DataInputStream(socket.getInputStream());
			 /*String fileName = dis.readUTF();  
             long fileLength = dis.readLong(); */
			 String fileName = "rasp.jpg";
             File directory = new File("D:/python/QingGuo_img/img");  
             if(!directory.exists()) {  
                 directory.mkdir();  
             }  
             File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);  
             fos = new FileOutputStream(file);  
             //System.out.println("1");
             // 开始接收文件  
             byte[] bytes = new byte[1024];  
             int length = 0; 
             //System.out.println("2");
             while((length = dis.read(bytes)) != -1) {
            	 //System.out.println(length);
                 fos.write(bytes, 0, length);  
                 fos.flush();  
             } 
             
             System.out.println("======== 文件接收成功 [File Name：" + fileName + "]"); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				if(fos != null) fos.close();
				if(dis != null) dis.close(); 
		        socket.close();
		        
		        Iterator<Socket> iterator = SocketPool.getSocketList().iterator();
		        while (iterator.hasNext()) {  
		            Socket so_t = iterator.next();
		            
		            String myIP = socket.getInetAddress().getHostAddress().toString();
		            String poolIP = so_t.getInetAddress().getHostAddress().toString();
		            
		            if(myIP.equals(poolIP))
		            {
		            	iterator.remove();
		            }
		        }
		        /*for(Socket s:SocketPool.getSocketList())
		        {
		        	System.out.println(s.getLocalAddress());
		        }*/
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}  
               
		}
		
	}
	
	
}
