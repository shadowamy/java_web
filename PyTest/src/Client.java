import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Socket socket = new Socket("localhost", 8086);
            //�������Ӻ󣬻�ȡ���������������˷�����Ϣ
            OutputStream os = socket.getOutputStream();
            //�������װΪ��ӡ��
            PrintWriter pw = new PrintWriter(os);
            //��������˷�����Ϣ
            pw.write("�û�����zzh;���룺123");//д���ڴ滺����
            pw.flush();//ˢ�»��棬��������������Ϣ
            socket.shutdownOutput();//�ر������
            
            //��ȡ�����������շ���������Ӧ��Ϣ
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
            String data = null;
            while((data=br.readLine())!= null){
                System.out.println("���ǿͻ��ˣ����������ύ��ϢΪ��"+data);
            }
            
            //�ر�������Դ
//            br.close();
//            is.close();
//            pw.close();
//            os.close();
            socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
