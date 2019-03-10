package backend.clubTable;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "ClubTable")
public class clubTable {

	@Id
	private String clubID;
	private String clubName;
	private String clubDomain;
	private String clubStatus;
	private ArrayList <String> clubMembers;
	private ArrayList <String> clubTags;

		
	public clubTable() {

	}

	public clubTable( String clubid, String clubname, String clubdomain, String clubstatus,
			ArrayList <String> clubMembers, ArrayList <String> clubTags) {
		super();

		this.clubMembers = clubMembers;
		this.clubTags = clubTags;
		this.clubName = clubname;
		this.clubID = clubid;
		this.clubDomain = clubdomain;
		this.clubStatus = clubstatus;

	}

	public String getClubID() {
		return clubID;
	}

	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubDomain() {
		return clubDomain;
	}

	public void setClubDomain(String clubDomain) {
		this.clubDomain = clubDomain;
	}

	public String getClubStatus() {
		return clubStatus;
	}

	public void setClubStatus(String clubStatus) {
		this.clubStatus = clubStatus;
	}

	public ArrayList<String> getClubMembers() {
		return clubMembers;
	}

	public void setClubMembers(ArrayList<String> clubMembers) {
		this.clubMembers = clubMembers;
	}
	
	public ArrayList<String> getClubTags() {
		return clubTags;
	}

	public void setClubTags(ArrayList<String> clubTags) {
		this.clubTags = clubTags;
	}

	
	
}