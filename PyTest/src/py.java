import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class py {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		
		Process proc;
		try {
			proc = Runtime.getRuntime().exec("python D:/iot/2019hanjia/cm/img-trans.py");

			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			while ((line = in.readLine())!=null) {
				if(line!=null)
					System.out.println(line);
			}

			in.close();
			proc.waitFor();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		 
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");*/
		ServerSocket serverSocket = new ServerSocket(8086);
		//Socket socket = null;
		
		System.out.println("***�����������������ȴ��ͻ��˵�����***");
		
		Socket socket = serverSocket.accept();
		System.out.println(socket);
		
		FileReceive fr = new FileReceive(socket);
		SocketPool.initList();
		SocketPool.addSocket(socket);
		for(Socket s:SocketPool.getSocketList())
        {
        	System.out.println(s.getInetAddress().getLocalHost());
        }
		
		OutputStream os_uno = null;
        PrintWriter pw_uno = null;
        os_uno = socket.getOutputStream();
        pw_uno = new PrintWriter(os_uno);
		
		InetAddress address = socket.getInetAddress();
        System.out.println("��ǰ�ͻ��˵�IPΪ��"+address.getHostAddress());
        pw_uno.write("file_send");
        pw_uno.flush();
        System.out.println("send");
		fr.doReceive();

	}

}
