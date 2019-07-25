import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ClientSender{
	Socket socket;	
	DataOutputStream out;	
	
	ClientSender(Socket socket){				
		try {
			this.socket = socket;
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("outputStream ���� ����");
			e.printStackTrace();
		}		
	}
	
	public void sendName(String name) {
		String msg = "["+name+"]���� �����ϼ̽��ϴ�.\n";
		sendMessage(msg);
	}
	
	public void sendMessage(String msg) {		
		
		if(out!=null) {
			try {
				byte[] b = msg.getBytes("UTF-8");
				out.write(b);				
				out.flush();
				
			} catch (IOException ie) {
				System.out.println("write ����");
				ie.printStackTrace();
			}
			
		}
		
	}
}