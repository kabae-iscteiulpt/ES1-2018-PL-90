package ComunPackage;

public class User {
	private String fullname;
	private String username;
	private int password;
	private String email;
	
	
	public User(String fullname, String username, int password, String email) {
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
