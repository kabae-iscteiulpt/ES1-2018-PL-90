package ServerPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import ComunPackage.Data;
import ComunPackage.DataUser;
import ComunPackage.TypeData;


public class HandlerUserOut implements Runnable{
	private Socket s;
	private ObjectOutputStream out;
	private Control ctrl;
	private BufferedReader readFile;
	private final String fileName="src/ServerPackage/dataUser.txt";
	private ArrayList<User> listUser=new ArrayList<User>();

	public HandlerUserOut(Socket s, Control ctrl) {
		this.s=s;
		this.ctrl=ctrl;
		con();
		readFile();
	}


	public void readFile() {
		FileReader file;
		try {
			file = new FileReader(fileName);
			readFile = new BufferedReader(file);			    
			String line=readFile.readLine();

			while(line != null) {

				String[] array=line.split(",");
				User user=new User(array[2], array[0], Integer.parseInt(array[1]), array[3]);
				listUser.add(user);

				line=readFile.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void con() {
		try {
			out=new ObjectOutputStream(s.getOutputStream());
			System.out.println("ConnectionOut done");
		} catch (IOException e) {

		}

	}


	public User Validate(DataUser data){

		for(User u: listUser) {
			if(data.getUsername().equals(u.getUsername()) && data.getPassword()==u.getPassword()) {
				return u;
			}
		}
		return null;
	}

	public void dataProcess() {
		Data data=ctrl.takeData();
		DataUser datauser=(DataUser) data.getContent();

		//log acess
		if (data.getType()==TypeData.REQUEST_LOG) {

			User u=Validate(datauser);

			if(u != null) {
				try {
					out.flush();
					out.writeObject(new Data(TypeData.ACESS_ACCEPT,new DataUser(u.getUsername(),
							u.getPassword(), u.getFullname(),u.getEmail())));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					out.flush();
					out.writeObject(new Data(TypeData.DENIED_ACESS,null));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		//sigin analize data

		if(data.getType()==TypeData.REQUEST_SIGN) {
			boolean can=true;

			for(User u:listUser) {
				if(u.getUsername()==datauser.getUsername()) {
					can=false;
					break;
				}
			}

			try {
				if(can==true) {
					out.flush();
					out.writeObject(new Data(TypeData.USER_DO_NOT_EXIST, null));
					User user=new User(datauser.getFullname(), datauser.getUsername(), datauser.getPassword(),datauser.getEmail());
					listUser.add(user);
					writeUser(fileName, user);


				}
				else {
					out.flush();
					out.writeObject(new Data(TypeData.USER_EXIST, null));				
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}

	public void writeUser(String fileName, User u) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(new File(fileName),true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(""+u.getUsername()+","+u.getPassword()+","
					+ ""+u.getFullname()+","+u.getEmail());
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public void run() {
		while(true) {
			dataProcess();
		}

	}


}
