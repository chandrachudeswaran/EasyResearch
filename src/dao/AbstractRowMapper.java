package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AbstractRowMapper implements RowMapper<Abstract> {

	public Abstract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Abstract abstractDetails = new Abstract();
		abstractDetails.setId(rs.getInt("abstractid"));
		abstractDetails.setAbstractname(rs.getString("name"));
		abstractDetails.setConferenceid(rs.getInt("conferenceid"));
		abstractDetails.setStatus(rs.getString("status"));
		abstractDetails.setText(rs.getString("text"));
		abstractDetails.setUsername(rs.getString("username"));
		return abstractDetails;
	}

	
}
