package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("ConferenceDao")
public class ConferenceDao {

	Logger logger = Logger.getLogger("ConferenceDao");
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Conference> getConferenceList() {
		return jdbc.query("select * from conference", new ConferenceRowMapper());

	}

	public List<Conference> parseConferenceList(String responseFromRest){
		List<Conference> listofConferences = new ArrayList<Conference>();
		try {
			JSONArray array = new JSONArray(responseFromRest);
			for(int i=0;i<array.length();i++){
				JSONObject object = array.getJSONObject(i);
				logger.log(Level.INFO,object.toString());
				Conference conference = new Conference(object.getInt("id"),
						object.getString("conferencename"),object.getString("conferencechair"),
						object.getString("abstractdate"), object.getString("paperdate"), 
						object.getString("postingdate"),object.getString("conferenceplace"));
				listofConferences.add(conference);
			}
		} catch (JSONException e) {
			logger.log(Level.SEVERE,e.toString());
		}
		return listofConferences;
	}
}
