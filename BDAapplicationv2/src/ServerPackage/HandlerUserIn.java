package ServerPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import ComunPackage.Data;

public class HandlerUserIn implements Runnable{

	private Socket s;
	private ObjectInputStream in;
	private Control ctrl;


	public HandlerUserIn(Socket s,Control ctrl) {
		this.s=s;
		this.ctrl=ctrl;
		try {
			connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void connect() throws IOException {
		in=new ObjectInputStream(s.getInputStream());
		System.out.println("ConnectionIn done");
	}

	@Override
	public void run() {
		while(true) {
			try {
				Data data=(Data) in.readObject();
				ctrl.putData(data);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

	}


}
