package version2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ComunClass {

	private BufferedReader readFile;
	private final String fileName="src/version2/dataUser.txt";
	private ArrayList<User1> listUser=new ArrayList<User1>();

	public ComunClass() {
		readFile();
	}


	public ArrayList<User1> getListUser(){
		return listUser;
	}

	public void setUser(User1 user) {
		listUser.add(user);
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


	public User1 Validate(String username, int password){

		for(User1 u: listUser) {
			if(username.equals(u.getUsername()) && password==u.getPassword())
				return u;
		}
		return null;
	}


	public void writeUser(User1 u) {
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


}
