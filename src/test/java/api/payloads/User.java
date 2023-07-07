package api.payloads;

public class User {

	int id;
	String first_name;
	String last_name;
	String avatar;
	String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}
	public String getLastname() {
		return last_name;
	}
	public void setLastname(String lastname) {
		this.last_name = lastname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
