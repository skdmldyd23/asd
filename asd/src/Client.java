

import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

class Client {
	
	String ip = "218.39.221.69";
	int port = 2222;	
	Socket socket;		
	ClientSender clientSender;
	ClientReader clientReader;
	String name;
	String readedMessage;
	
	Client(){		
		try {
			socket = new Socket(ip, port);					
			clientSender = new ClientSender(socket);
			clientReader = new ClientReader(socket);
			//clientReader.start();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void threadStart() {
		clientReader.start();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void sendName() {
		clientSender.sendName(name);
	}
	
	public void sendMessage(String msg) {
		clientSender.sendMessage(msg);		
	}

	public String readMessage() {
		String str =  clientReader.readMessage();
		clientReader.setMessage();
		return str;
	}
	
	public void setTextArea(JTextArea textArea) {
		clientReader.setTextArea(textArea);
	}
//	public ClientSender getSender() {
//		return this.clientSender;
//	}
//	
//	public ClientReader getReader() {
//		return this.clientReader;
//	}
}
