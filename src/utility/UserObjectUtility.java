package utility;

import org.json.JSONObject;

import dao.User;
import dao.UserAddress;

public class UserObjectUtility {
	
	
	public static User getUserObjectFromJson(String profile){
		
		JSONObject obj = new JSONObject(profile);
		User user = new User();
		user.setUsername(obj.getString("username"));
		user.setPassword(obj.getString("password"));
		user.setEmail(obj.getString("email"));
		user.setCompany(obj.getString("company"));
		user.setName(obj.getString("name"));
		user.setLastname(obj.getString("lastname"));
		user.setType(obj.getString("type"));
		UserAddress address = new UserAddress();
		address.setStreet(obj.getJSONObject("address").getString("street"));
		address.setCity(obj.getJSONObject("address").getString("city"));
		address.setState(obj.getJSONObject("address").getString("state"));
		address.setCountry(obj.getJSONObject("address").getString("country"));
		user.setAddress(address);
		return user;
		
	}

}
