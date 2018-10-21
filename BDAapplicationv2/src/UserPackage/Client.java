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
import ComunPackage.DataUser;
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

	public void start() {

		connectUser();
		new Thread(new HandlerInput()).start();
		logFrame=new LoginFrame(out);
		siginUpFrame=new SiginUpFrame(out);
		homeFrame=new Home_Window(in, out);
		init=new InitialFrame();
		init.setVisible(true);
		
	}

	public void connectUser(){

		try {
			InetAddress address=InetAddress.getByName(null);
			socketUser=new Socket(address, PORTO);
			in=new ObjectInputStream(socketUser.getInputStream());
			out= new ObjectOutputStream(socketUser.getOutputStream());
			System.out.println("User Connected to Server");
		} catch (UnknownHostException e) {}
		
		catch (IOException e) {}
	}

	//process the data that comming from Server
	public void processDataFromServer() throws ClassNotFoundException, IOException {

		Data data=(Data) in.readObject();
		TypeData type=data.getType();

		switch (type){

		case ACESS_ACCEPT:

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DataUser datauser=(DataUser) data.getContent();
						logFrame.dispose();
						homeFrame.setUserNameAndMail(datauser.getFullname(),datauser.getEmail());
						homeFrame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Sucess Login");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			break;

		case DENIED_ACESS:

			JOptionPane.showMessageDialog(null, "Username and/or password incorrect!");

			break;

		case USER_DO_NOT_EXIST:

			EventQueue.invokeLater(new Runnable() {
				public void run() {					
					try {
						siginUpFrame.dispose();
						logFrame.setVisible(true);
						JOptionPane.showMessageDialog(null, "Account created successfuly");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			break;

		case USER_EXIST:

			JOptionPane.showMessageDialog(null, "Atention: Username already exist! Try new username");

			break;

		default:

			JOptionPane.showMessageDialog(null,"Invalid!");

			break;
		}
	}


	private class HandlerInput implements Runnable{

		@Override
		public void run() {

			while(true) {
				try {
					processDataFromServer();
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
