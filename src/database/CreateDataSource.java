package database;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import utility.ServerAddressHelper;

public class CreateDataSource extends BasicDataSource {
	
	
	public String url;
	public String username;
	public String password;
	public String driverClassName;
	
	public CreateDataSource() {
		if(ServerAddressHelper.isLocalServer()){
			url ="jdbc:mysql://127.0.0.1:3306/easyresearch";
			username="root";
			password="root";
			driverClassName="com.mysql.jdbc.Driver";
		}else{
			driverClassName="com.mysql.jdbc.Driver";
			username="adminKTBee1r";
			password="N_GLp9Ryik2X";
			url="jdbc:mysql://127.3.163.130:3306/easyresearch";
		}
	}
	

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
