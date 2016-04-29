package dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userdao")
public class UserDao {
	Logger logger = Logger.getLogger("UserDao");
	
	private NamedParameterJdbcTemplate jdbc;
	

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public boolean isLoginSuccess(String username,String password,String type){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username.trim().toString());
		params.addValue("password", password.trim().toString());
		params.addValue("type", type.trim().toString());
		String sqlStatement= "select count(*) as count from users where username=:username and password=:password and type=:type";
		int value = jdbc.queryForObject(sqlStatement, params,Integer.class);
		logger.log(Level.INFO,value+"");
		return value==1;
	}
	
	public boolean doSignupUser(User user){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", user.getPassword());
		params.addValue("name", user.getName());
		params.addValue("email", user.getEmail());
		params.addValue("address", user.getAddress().toString());
		params.addValue("type", user.getType());
		params.addValue("lastname", user.getLastname());
		params.addValue("company", user.getCompany());
		String sql = "insert into users values(:username,:password,:email,:name,:address,:type,:lastname,:company)";
		return jdbc.update(sql, params)==1;
	}
	
	public boolean isUserExists(String username,String email){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);
		params.addValue("email", email);
		return jdbc.queryForObject("select count(username) as count from users where username=:username and email=:email", params,Integer.class)>=1;
	}
	
	public boolean editUserAccount(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update("update users set password =:password,name=:name,address=:address where username=:username", params)==1;
	}
	
	public String getUserEmail(String username){
		MapSqlParameterSource params = new MapSqlParameterSource("username",username);
		return jdbc.queryForObject("select email from users where username=:username", params, String.class);
	}
	
	public User getUserDetails(String username){
		MapSqlParameterSource params = new MapSqlParameterSource("username",username);
		return jdbc.queryForObject("select * from users where username=:username", params, new UserRowMapper());
	}

}
