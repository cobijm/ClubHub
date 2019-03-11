package backend.clubEnrollment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubenrollment")

public class clubEnrollment {
	
	@Id
	private String enrollmentNumber;
	private String clubID;
	private String clubStanding;
	private String expirationDate;
	private String joinDate;
	private String ranking;
	private String studentID;


	
	public clubEnrollment()
	{
		
	}
	
	public clubEnrollment(String enrollmentnumber,String clubid,String clubstanding , String expirationdate, String joindate ,String ranking, String studentid )
	{
		this.clubID = clubid;
		this.enrollmentNumber = enrollmentnumber;
		this.studentID = studentid;
		this.ranking = ranking;
		this.joinDate = joindate;
		this.expirationDate = expirationdate;
		this.clubStanding = clubstanding;

		
	}

	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}


	public String getClubStanding() {
		return clubStanding;
	}

	public void setClubStanding(String clubStanding) {
		this.clubStanding = clubStanding;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getClubID() {
		return clubID;
	}

	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}





	
	
	
	
	
}
