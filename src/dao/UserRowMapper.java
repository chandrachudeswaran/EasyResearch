package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<User> {
	
	Logger logger = Logger.getLogger("UserRowMapper");
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		UserAddress address = new UserAddress();
		String[] array = rs.getString("address").split(",");
		address.setCity(array[1]);
		address.setStreet(array[0]);
		address.setState(array[2]);
		address.setCountry(array[3]);
		user.setAddress(address);
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setLastname(rs.getString("lastname"));
		user.setName(rs.getString("name"));
		user.setCompany(rs.getString("company"));
		user.setEmail(rs.getString("email"));
		user.setType(rs.getString("type"));
		return user;
	}

}
