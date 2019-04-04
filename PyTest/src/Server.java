import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			ServerSocket serverSocket = new ServerSocket(8086);
			Socket socket = null;
			SocketPool.initList();
			
			System.out.println("***服务器即将启动，等待客户端的连接***");
            while(true){//循环侦听新的客户端的连接
                //调用accept（）方法侦听，等待客户端的连接以获取Socket实例
                socket = serverSocket.accept();
                SocketPool.addSocket(socket);
                /*for(Socket s:SocketPool.getSocketList())
                {
                	System.out.println(s.getInetAddress().getHostAddress().toString());
                }*/
                if(!socket.getInetAddress().getHostAddress().toString().equals("192.168.1.102"))
                {
	                //创建新线程
	                Thread thread = new Thread(new ServerThread(socket));
	                thread.start();
                }
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP为："+address.getHostAddress());
            }  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		
	}

}
