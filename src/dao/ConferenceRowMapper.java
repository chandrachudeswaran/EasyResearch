package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConferenceRowMapper implements RowMapper<Conference> {

	public Conference mapRow(ResultSet rs, int rowNum) throws SQLException {
		Conference conference = new Conference();
		conference.setId(rs.getInt("conferenceid"));
		conference.setConferencename(rs.getString("name"));
		conference.setConferencechair(rs.getString("chair"));
		conference.setAbstractdate(rs.getDate("abstractdate").toString());
		conference.setPaperdate(rs.getDate("paperdate").toString());
		conference.setPostingdate(rs.getDate("postingdate").toString());
		conference.setConferenceplace(rs.getString("place"));
		return conference;
	}

}
