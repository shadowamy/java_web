import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

	
	Socket socket = null;//和本线程相关的Socket
    
    public ServerThread(Socket socket) 
    {
    	this.socket = socket;
    }
    
    
	public void run() {
		// TODO Auto-generated method stub
		
		InputStream is_uno = null;
        InputStreamReader isr_uno = null;
        BufferedReader br_uno = null;
        OutputStream os_uno = null;
        PrintWriter pw_uno = null;
        try 
        {
        	//与客户端建立通信，获取输入流，读取取客户端提供的信息
        	is_uno = socket.getInputStream();
            isr_uno = new InputStreamReader(is_uno,"GBK");
            br_uno = new BufferedReader(isr_uno);
            
            os_uno = socket.getOutputStream();
            pw_uno = new PrintWriter(os_uno);
        	while (true)
        	{
           
            
	            String data = null;
	            String order = null;
	            while((data=br_uno.readLine()) != null){//循环读取客户端的信息
	                System.out.println("我是服务器，客户端提交信息为："+data);
	                //pw.write("服务器端响应成功");
	                //if(data.equals("init_end")) break;
	                if(data.equals("hello"))
	                {
	                	order = "hello";
	                	break;
	                }
	                else if(data.equals("what"))
	                {
	                	order = "what";
	                	break;
	                }
	            }
	            
	            if(order.equals("hello"))
	            {
	            	
	            	pw_uno.write("你好,我是小黑");
	            	pw_uno.flush();
	            }
	            else if(order.equals("what"))
	            {
	            	Socket socket_rasp = null;
	            	for(Socket s:SocketPool.getSocketList())
	            	{
	            		if(s!=socket)
	            		{
	            			socket_rasp = s;
	            			break;
	            		}
	            	}
	            	System.out.println(socket_rasp);
	            	
	                OutputStream os_rasp = socket_rasp.getOutputStream();
	                PrintWriter pw_rasp = new PrintWriter(os_rasp);
	                pw_rasp.write("file_send");
	                pw_rasp.flush();
	                System.out.println("send");
	                
	            	FileReceive fr = new FileReceive(socket_rasp);
	            	fr.doReceive();
	            	
	            	
	            	ImageResult ir = new ImageResult();
	            	String result = ir.getResult();
	            	if(result!=null&&!result.equals(""))
	            	{
	            		System.out.println(result);
		            	pw_uno.write("这是"+result);
		            	pw_uno.flush();
		            	Robot r = new Robot();
		            	r.delay(2000);
	            	}
	            	else
	            	{
	            		pw_uno.write("我不知道");
		            	pw_uno.flush();
	            	}
	            	
	            }
	            
	            
	            //socket.shutdownInput();//关闭输入流
	            //获取输出流，响应客户端的请求
	            //os = socket.getOutputStream();
	            //pw = new PrintWriter(os);
	            //pw.write("服务器端响应成功");
	            //pw.flush();
        	}
        	
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            //关闭资源即相关socket
            try 
            {
                if(pw_uno!=null)
                    pw_uno.close();
                if(os_uno!=null)
                    os_uno.close();
                if(br_uno!=null)
                    br_uno.close();
                if(isr_uno!=null)
                    isr_uno.close();
                if(is_uno!=null)
                    is_uno.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
		
	}

}
