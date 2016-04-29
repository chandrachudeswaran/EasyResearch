package service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.User;
import dao.UserAddress;
import dao.UserDao;

@Service("userservice")
public class UserService {
	Logger logger = Logger.getLogger("UserService");

	@Autowired
	private UserDao userdao;


	public boolean isLoginSuccess(String username, String password,String type) {
		return userdao.isLoginSuccess(username, password,type);
	}
	
	public boolean doSignupUser(String username,String password,String name,String lastname,String email,String company,
			String street,String city,String state,String country,String type){
		UserAddress address = new UserAddress(street, city, state, country);
		User user = new User(username, password, email,company, name,lastname, address, type);
		return userdao.doSignupUser(user);
	}
	
	public boolean isUserExists(String username,String email){
		return userdao.isUserExists(username, email);
	}
	
	public boolean editUserAccount(String password,String name,
			String street,String city,String state,String country){
		UserAddress address = new UserAddress(street, city, state, country);
		User user = new User(password,name,address);
		return userdao.editUserAccount(user);
	}
	
	public String getUserEmail(String username){
		return userdao.getUserEmail(username);
	}
	
	public User getUserDetails(String username){
		return userdao.getUserDetails(username);
	}
}
