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
			
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
            while(true){//ѭ�������µĿͻ��˵�����
                //����accept���������������ȴ��ͻ��˵������Ի�ȡSocketʵ��
                socket = serverSocket.accept();
                SocketPool.addSocket(socket);
                /*for(Socket s:SocketPool.getSocketList())
                {
                	System.out.println(s.getInetAddress().getHostAddress().toString());
                }*/
                if(!socket.getInetAddress().getHostAddress().toString().equals("192.168.1.102"))
                {
	                //�������߳�
	                Thread thread = new Thread(new ServerThread(socket));
	                thread.start();
                }
                InetAddress address = socket.getInetAddress();
                System.out.println("��ǰ�ͻ��˵�IPΪ��"+address.getHostAddress());
            }  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		
	}

}
