package service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Conference;
import dao.ConferenceDao;

@Service("conferenceservice")
public class ConferenceService {
	
	Logger logger = Logger.getLogger("ConferenceService");

	@Autowired
	private ConferenceDao conferencedao;
	
	public List<Conference> getConferenceList(){
		return conferencedao.getConferenceList();
	}
	
	public List<Conference> parseConferenceList(String responseFromRest){
		return conferencedao.parseConferenceList(responseFromRest);
	}
	

}
