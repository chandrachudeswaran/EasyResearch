package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.ConferenceService;
import utility.RestClient;
import utility.UserObjectUtility;
import constants.EasyResearchConstants;
import dao.Conference;

@Controller
public class HomeController {
	Logger logger = Logger.getLogger("HomeController");

	@Autowired
	private RestClient restclient;
	@Autowired
	private ConferenceService conferenceservice;
	
	

	@RequestMapping("/")
	public String showHome(Model model) {
		List<Conference> listofConferences = conferenceservice.
				parseConferenceList(restclient.getResponseFromRest(EasyResearchConstants.WEB_URL+"getConferences","GET"));
		model.addAttribute("conferences", listofConferences);
		return "home";
	}

	@RequestMapping("/aboutus")
	public String showAboutUs(HttpServletRequest request,Model model) {
		return "aboutus";
	}

	@RequestMapping("/contactus")
	public String showContactUs() {
		return "contactus";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String showUserLogin(@RequestParam("type") String userType,
			Model model) {
		model.addAttribute("usertype", userType);
		return "userlogin";
	}
	
	@RequestMapping(value = "/formlogin")
	public String showFormLogin(){
		return "formlogin";
	}
	
	
	@RequestMapping(value = "/douserlogin", method = RequestMethod.POST)
	public String douserlogin(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("typeofuser") String type, Model model) {
		logger.log(Level.INFO, username);
		restclient.addParams("username", username);
		restclient.appendParams("password", password);
		restclient.appendParams("typeofuser", type);
		String status = restclient.checkMethodandCallRest(EasyResearchConstants.WEB_URL+"login", "POST");
		logger.log(Level.INFO, restclient.toString());
		if (status.equals("success")) {
			model.addAttribute("username", username);
			return "userhome";
		} else {
			model.addAttribute("userstatus", "invalid");
			model.addAttribute("usertype", type);
			return "userlogin";
		}
	}
	

	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public String showUserHome() {
		return "userhome";
		}

	@RequestMapping(value = "/usersignup", method = RequestMethod.GET)
	public String showUserSignup(@RequestParam("type") String type, Model model) {
		model.addAttribute("type", type);
		return "usersignup";
	}

	@RequestMapping(value = "/dousersignup", method = RequestMethod.POST)
	public String douserSignup(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("lname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("company") String company,
			@RequestParam("street") String street,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("country") String country,
			@RequestParam("type") String type, Model model) {

		restclient.addParams("username", username);
		restclient.appendParams("password", password);
		restclient.appendParams("name", name);
		restclient.appendParams("lname", lastname);
		restclient.appendParams("email", email);
		restclient.appendParams("company", company);
		restclient.appendParams("street", street);
		restclient.appendParams("city", city);
		restclient.appendParams("state", state);
		restclient.appendParams("country", country);
		restclient.appendParams("type", type);

		String status = restclient.checkMethodandCallRest(
				EasyResearchConstants.WEB_URL+"signup", "POST");
		model.addAttribute("usertype", type);
		if (status.equals("success")) {
			return "userhome";
		} else {
			model.addAttribute("status", "invalid");
			return "usersignup";
		}
	}
	
	
	@RequestMapping(value ="/editprofile", method= RequestMethod.GET)
	public String doEditProfile(@RequestParam("username") String username,Model model){
		restclient.addParams("username", username);
		String profile = restclient.checkMethodandCallRest(EasyResearchConstants.WEB_URL+"editprofileuser", "POST");
		model.addAttribute("user", UserObjectUtility.getUserObjectFromJson(profile));
		return "editprofile";
	}

}
