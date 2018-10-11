package UserPackage;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import ComunPackage.Data;
import ComunPackage.TypeData;


public class Client {

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socketUser;
	private final int PORTO=8901;

	//frames
	private InitialFrame init;
	public static LoginFrame logFrame;
	public static SiginUpFrame siginUpFrame;
	public static Home_Window homeFrame;


	public Client() {

	}

	void start() {
		connectUser();
		new Thread(new HandlerInput()).start();
		logFrame=new LoginFrame(out);
		siginUpFrame=new SiginUpFrame(out);
		homeFrame=new Home_Window(in, out);
		init=new InitialFrame();
		init.setVisible(true);
	}

	public void connectUser() {
		try {
			InetAddress address=InetAddress.getByName(null);
			socketUser=new Socket(address, PORTO);
			in=new ObjectInputStream(socketUser.getInputStream());
			out= new ObjectOutputStream(socketUser.getOutputStream());
			System.out.println("User Connected to Server");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private class HandlerInput implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					Data data=(Data) in.readObject();
					
					if(data.getType()==TypeData.ACESS_ACCEPT) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
													
									logFrame.setVisible(false);	
									homeFrame.setVisible(true);
									JOptionPane.showMessageDialog(null, "Sucess Login");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					
					if(data.getType()==TypeData.DENIED_ACESS) {
						JOptionPane.showMessageDialog(null, "Username or password incorect!");
					}
					
					if(data.getType()==TypeData.USER_DO_NOT_EXIST) {
						siginUpFrame.setVisible(false);
						logFrame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Account created successefuly");
						
					}
					
					if(data.getType()==TypeData.USER_EXIST) {
						JOptionPane.showMessageDialog(null, "Username already exist!");
					}
					
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public static void main(String[] args) {
		new Client().start();
	}

}
