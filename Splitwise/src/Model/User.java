package Model;

public class User {
	private int id;
	private String name;
	private String email;
	private String mobileNumber;
	
	public User(int id, String name, String email, String mobileNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	public int getUserid() {
		return id;
	}
	
	public void setUserid(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String name) {
		this.mobileNumber = mobileNumber;
	}
}
