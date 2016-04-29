package dao;

import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("AbstractDao")
public class AbstractDao {

	Logger logger = Logger.getLogger("AbstractDao");
	private NamedParameterJdbcTemplate jdbc;
	

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean submitAbstractForUser(Abstract abstractDetails) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(abstractDetails);
		return jdbc.update("insert into abstract(name,text,username,conferenceid,status) "
				+ "values(:abstractname,:text,:username,:conferenceid,:status)",params)==1;
	}
	
	
	public boolean updateStatusForAbstract(int abstractid,String status){
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("id", abstractid);
		params.addValue("status",status);
		return jdbc.update("update abstract set status=:status where abstractid=:abstractid", params)==1;
		
	}
	
	public List<Abstract> getAbstracts(int conferenceid,String status){
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("conferenceid", conferenceid);
		params.addValue("status", status);
		return jdbc.query("select * from abstract where conferenceid=:conferenceid and status=:status", params,new AbstractRowMapper());
	}
}
