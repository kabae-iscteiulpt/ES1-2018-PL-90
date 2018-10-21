package ComunPackage;

import java.io.Serializable;

public class User1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fullname;
	private String username;
	private int password;
	private String email;
	
	
	public User1(String fullname, String username, int password, String email) {
		this.fullname=fullname;
		this.username=username;
		this.password=password;
		this.email=email;		
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


	public String getEmail() {
		return email;
	}

}
