package constants;

import java.util.logging.Logger;

import utility.ServerAddressHelper;

public class EasyResearchConstants {
	static Logger logger = Logger.getLogger("EasyResearchConstants");
	
	public static final String WEB_URL= getWebURL() ;
	public static final String OPEN_SHIFT_SERVER_NAME="ex-std-node483.prod.rhcloud.com";
	
	private static final String OPEN_SHIFT_SERVER_URL="http://easyresearch-chudeswaran.rhcloud.com/EasyResearch/";
	private static final String LOCAL_SERVER_URL="http://localhost:8080/easyresearch/";
	
	
	public static String getWebURL(){
		 if(ServerAddressHelper.isLocalServer()){
			 return LOCAL_SERVER_URL;
		 }else{
			 return OPEN_SHIFT_SERVER_URL;
		 }
	}
}
