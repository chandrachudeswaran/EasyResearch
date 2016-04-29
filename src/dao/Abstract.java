package dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class Abstract {
	private int id;
	private String abstractname;
	private String text;
	private String username;
	private int conferenceid;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAbstractname() {
		return abstractname;
	}
	public void setAbstractname(String abstractname) {
		this.abstractname = abstractname;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getConferenceid() {
		return conferenceid;
	}
	public void setConferenceid(int conferenceid) {
		this.conferenceid = conferenceid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Abstract(){
		
	}
	public Abstract(String abstractname, String text, String username,
			int conferenceid,String status) {
		this.abstractname = abstractname;
		this.text = text;
		this.username = username;
		this.conferenceid = conferenceid;
		this.status=status;
	}
	
	
	

}
