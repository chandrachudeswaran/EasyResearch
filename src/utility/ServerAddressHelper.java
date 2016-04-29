package utility;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import constants.EasyResearchConstants;

public class ServerAddressHelper {
	static Logger logger = Logger.getLogger("ServerAddressHelper");
	
	public static boolean isLocalServer(){
		try {
			String deployedServerName = InetAddress.getLocalHost().getHostName();
			if(deployedServerName!=null){
				if(EasyResearchConstants.OPEN_SHIFT_SERVER_NAME.equals(deployedServerName)){
					return false;
				}else{
					return true;
				}
			}
		} catch (UnknownHostException e) {
			logger.log(Level.SEVERE,e.toString());
			
		}
		return false;
	}
}
