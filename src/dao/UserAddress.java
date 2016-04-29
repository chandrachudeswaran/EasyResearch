package dao;

public class UserAddress {

	private String street;
	private String city;
	private String state;
	private String country;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public UserAddress(){
		
	}
	@Override
	public String toString() {
		return  street + "," + city + ","
				+ state + ","+ country;
	}
	public UserAddress(String street, String city, String state, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
	
}
