package backend.clubEnrollment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubEnrollment")
public class clubEnrollment {

	@Id
	private String enrollmentID;
	private String clubID;
	private String studentID;
	private String rank;
	private String joinDate;
	private String expirationDate;
	private String clubStanding;

	public clubEnrollment() {

	}

	public clubEnrollment(String enrollmentid, String clubid, String studentid, String rank, String joinDate, 
			String expirationDate, String clubStanding) {
		super();
		this.enrollmentID = enrollmentid;
		this.clubID = clubid;
		this.studentID = studentid;
		this.rank = rank;
		this.joinDate = joinDate;
		this.expirationDate = expirationDate;
		this.clubStanding = clubStanding;
	}

	public String getClubId() {
		return clubID;
	}

	public void setClubId(String clubid) {
		this.clubID = clubid;
	}
	
	public String getStudentId() {
		return studentID;
	}

	public void setNetid(String studentid) {
		this.studentID = studentid;
	}
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getClubStanding() {
		return clubStanding;
	}

	public void setClubStanding(String clubStanding) {
		this.clubStanding = clubStanding;
	}
	
	public String getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
	}
}