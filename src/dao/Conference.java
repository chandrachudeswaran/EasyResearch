package dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY )
public class Conference {
	private int id;
	private String conferencename;
	private String conferencechair;
	private String conferenceplace;
	private String abstractdate;
	private String paperdate;
	private String postingdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConferencename() {
		return conferencename;
	}
	public void setConferencename(String conferencename) {
		this.conferencename = conferencename;
	}
	public String getConferencechair() {
		return conferencechair;
	}
	public void setConferencechair(String conferencechair) {
		this.conferencechair = conferencechair;
	}
	public String getConferenceplace() {
		return conferenceplace;
	}
	public void setConferenceplace(String conferenceplace) {
		this.conferenceplace = conferenceplace;
	}
	public String getAbstractdate() {
		return abstractdate;
	}
	public void setAbstractdate(String abstractdate) {
		this.abstractdate = abstractdate;
	}
	public String getPaperdate() {
		return paperdate;
	}
	public void setPaperdate(String paperdate) {
		this.paperdate = paperdate;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	
	public Conference(){
		
	}
	public Conference(int id, String conferencename, String conferencechair,
			String abstractdate, String paperdate, String postingdate,String conferenceplace) {
		this.id = id;
		this.conferencename = conferencename;
		this.conferencechair = conferencechair;
		this.abstractdate = abstractdate;
		this.paperdate = paperdate;
		this.postingdate = postingdate;
		this.conferenceplace=conferenceplace;
	}
	@Override
	public String toString() {
		return "Conference [id=" + id + ", conferencename=" + conferencename
				+ ", conferencechair=" + conferencechair + ", abstractdate="
				+ abstractdate + ", paperdate=" + paperdate + ", postingdate="
				+ postingdate + "]";
	}
	
	

}
