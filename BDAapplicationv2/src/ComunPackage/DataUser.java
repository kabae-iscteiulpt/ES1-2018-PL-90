package ComunPackage;

import java.io.Serializable;

public class DataUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private int password;
	private String fullname;
	private String email;

	public DataUser(String username, int i, String fullname, String email) {
		this.username=username;
		this.password=i;
		this.fullname=fullname;
		this.email=email;
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public int getPassword() {
		return password;
	}

}
