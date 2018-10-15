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
import ComunPackage.User1;


public class HandlerUserOut implements Runnable{
	private Socket s;
	private ObjectOutputStream out;
	private Control ctrl;
	private BufferedReader readFile;
	private final String fileName="src/ServerPackage/dataUser.txt";
	private ArrayList<User1> listUser=new ArrayList<User1>();

	public HandlerUserOut(Socket s, Control ctrl) {
		this.s=s;
		this.ctrl=ctrl;
		readFile();
		connect();
	}


	public void readFile() {
		FileReader file;
		try {
			file = new FileReader(fileName);
			readFile = new BufferedReader(file);			    
			String line=readFile.readLine();

			while(line != null) {

				String[] array=line.split(",");
				User1 user=new User1(array[2], array[0], Integer.parseInt(array[1]), array[3]);
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

	public void connect() {
		try {
			out=new ObjectOutputStream(s.getOutputStream());
			System.out.println("ConnectionOut done");
		} catch (IOException e) {

		}

	}


	public User1 Validate(DataUser data){

		for(User1 u: listUser) {
			if(data.getUsername().equals(u.getUsername()) && data.getPassword()==u.getPassword()) {
				return u;
			}
		}
		return null;
	}

	// Process the data that coming from Client
	public void dataProcess() throws IOException {
		Data data=ctrl.takeData();
		DataUser datauser=(DataUser) data.getContent();

		//log acess analyze data
		if (data.getType()==TypeData.REQUEST_LOG){

			User1 u=Validate(datauser);

			if(u != null) {
				out.flush();
				out.writeObject(new Data(TypeData.ACESS_ACCEPT,new DataUser(u.getUsername(),
						u.getPassword(), u.getFullname(),u.getEmail())));
			}
			else {
				out.flush();
				out.writeObject(new Data(TypeData.DENIED_ACESS,null));
			}

		}

		//sigin analyze data

		if(data.getType()==TypeData.REQUEST_SIGN) {

			for(User1 u:listUser) {
				if(u.getUsername().equals(datauser.getUsername())) {
					out.flush();
					out.writeObject(new Data(TypeData.USER_EXIST, null));
					return;
				}

			}
			out.flush();
			out.writeObject(new Data(TypeData.USER_DO_NOT_EXIST, null));
			User1 user=new User1(datauser.getFullname(), datauser.getUsername(), datauser.getPassword(),datauser.getEmail());
			listUser.add(user);
			//regist user in the file
			writeUser(fileName, user);
		}


	}


	public void writeUser(String fileName, User1 u) {
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
			try {
				dataProcess();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}

	}


}
