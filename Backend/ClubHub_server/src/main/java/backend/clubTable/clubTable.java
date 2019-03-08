package backend.clubTable;

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

	public clubTable() {

	}

	public clubTable(String clubname, String clubid, String clubdomain, String clubstatus ) {
		super();

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

	
	
	
}