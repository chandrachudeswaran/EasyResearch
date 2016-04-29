package dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class User {

	private String username;
	private String password;
	private String email;
	private String company;
	private String name;
	private String lastname;
	private UserAddress address;
	private String type;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User() {

	}

	public User(String username, String password, String email,String company ,String name,String lastname,
			UserAddress address, String type) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.address = address;
		this.type = type;
		this.lastname=lastname;
		this.company=company;
	}
	
	

	public User(String password, String name, UserAddress address) {
		this.password = password;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", company=" + company + ", name="
				+ name + ", lastname=" + lastname + ", address=" + address
				+ ", type=" + type + "]";
	}

	
	
	
}
