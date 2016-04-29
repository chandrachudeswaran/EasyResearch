package restcontroller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.AbstractService;
import service.ConferenceService;
import service.UserService;
import dao.Abstract;
import dao.Conference;
import dao.User;

@RestController
public class RestUserController {
	Logger logger = Logger.getLogger("RestHome");

	@Autowired
	private UserService userservice;
	@Autowired
	private ConferenceService conferenceservice;
	@Autowired
	private AbstractService abstractservice;

	

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String doLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("typeofuser") String type) {
		logger.log(Level.INFO,username);
		if (userservice.isLoginSuccess(username, password,type)) {
			return "success";
		} else {
			return "failure";
		}
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String doSignup(@RequestParam("username") String username,@RequestParam("password") String password,
			@RequestParam("name") String name,@RequestParam("lname") String lastname,@RequestParam("email") String email,
			@RequestParam("company") String company,
			@RequestParam("street") String street,@RequestParam("city") String city,
			@RequestParam("state") String state,@RequestParam("country") String country,
			@RequestParam("type") String type) {
		if (userservice.doSignupUser(username, password, name,lastname, email,company, street,
				city, state, country, type)) {
			return "success";
		} else {
			return "failure";
		}

	}
	
	
	@RequestMapping(value="/userexists",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String isUserExists(@RequestParam("username") String username,@RequestParam("email") String email){
		if(userservice.isUserExists(username, email)){
			return "exists";
		}else{
			return "notexists";
		}
	}
	
	@RequestMapping(value="/editprofileuser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public User showEditProfileForUser(@RequestParam("username") String username){
		logger.log(Level.INFO,"username before calling db :" + username );
		return userservice.getUserDetails(username);
	}
	
	
	@RequestMapping(value="/edituser",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String editUserAccount(@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("street") String street,@RequestParam("city") String city,
			@RequestParam("state") String state,@RequestParam("country") String country){
		if(userservice.editUserAccount(password, name, street, city, state, country)){
			return "success";
		}else{
			return "failure";
		}
	}
	
	
	@RequestMapping(value="/getemail",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getUserEmail(@RequestParam("username") String username){
		return userservice.getUserEmail(username);
	}
	
	
	
	@RequestMapping(value="/getConferences",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Conference> getConferencesList(){
		return conferenceservice.getConferenceList();
	}
	
	
	
	@RequestMapping(value="/submitabstract",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String submitAbstract(@RequestParam("abstractname") String abstractname,
			@RequestParam("text") String text,@RequestParam("username") String username,
			@RequestParam("conferenceid") String conferenceid,@RequestParam("status") String status){
		if(abstractservice.submitAbstractForUser(abstractname, text, username, conferenceid, status)){
			return "success";
		}else{
			return "failure";
		}
	}
	
	
	@RequestMapping(value="/updateabstract",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String updateAbstract(@RequestParam("abstractid") String id,@RequestParam("status") String status){
		int abstractid = Integer.valueOf(id);
		if(abstractservice.updateStatusForAbstract(abstractid, status)){
			return "success";
		}else{
			return "failure";
		}
	}
	
	
	
	@RequestMapping(value="/getabstracts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Abstract> getAllAbstracts(@RequestParam("conferenceid") 
	String id,@RequestParam("status") String status){
		int conferenceid = Integer.valueOf(id);
		return abstractservice.getAbstracts(conferenceid, status);
	}
}
