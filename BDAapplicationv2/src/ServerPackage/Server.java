package ServerPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket ss;
	private final int PORTO=8901;
	private Control control=new Control();


	public void connect(){
		try {
			
			ss= new ServerSocket(PORTO);
			do {
				System.out.println("Waiting for connections...");
				Socket s=ss.accept();
				System.out.println("Conection accept: "+s);
		
				new Thread(new HandlerUserOut(s,control)).start();
				new Thread(new HandlerUserIn(s,control)).start();
			}
			while(true);

		} catch (IOException e) {

		}

	}

	public static void main(String[] args) {
		new Server().connect();
	}
}
