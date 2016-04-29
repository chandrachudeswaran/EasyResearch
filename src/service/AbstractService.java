package service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Abstract;
import dao.AbstractDao;

@Service("AbstractService")
public class AbstractService {

	Logger logger = Logger.getLogger("AbstractService");
	
	@Autowired
	private AbstractDao abstractDao;
	
	public boolean submitAbstractForUser(String abstractname,String text,String username,String conferenceid,String status) {
		int id = Integer.valueOf(conferenceid);
		Abstract abstractDetails = new Abstract(abstractname, text, username, id,status);
		return abstractDao.submitAbstractForUser(abstractDetails);
	}
	
	public boolean updateStatusForAbstract(int abstractid,String status){
		return abstractDao.updateStatusForAbstract(abstractid, status);
	}
	
	public List<Abstract> getAbstracts(int conferenceid,String status){
		return abstractDao.getAbstracts(conferenceid, status);
	}

}
