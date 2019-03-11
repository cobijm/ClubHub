package backend.clubEnrollment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubenrollment")

public class clubEnrollment {
	
	@Id
	private String enrollmentNumber;
	private String studentID;
	private String ranking;
	private String joinDate;
	private String expirationDate;
	private String clubStanding;
	
	
	public clubEnrollment()
	{
		
	}
	
	public clubEnrollment(String enrollmentnumber,String studentid ,String ranking, String joindate, String expirationdate , String clubstanding)
	{
		this.enrollmentNumber = enrollmentnumber;
		this.studentID = studentid;
		this.ranking = ranking;
		this.joinDate = joindate;
		this.expirationDate = expirationdate;
		this.clubStanding = clubstanding;

		
	}

	public String getEnrollmentID() {
		return enrollmentNumber;
	}

	public void setEnrollmentID(String enrollmentnumber) {
		this.enrollmentNumber = enrollmentnumber;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getRank() {
		return ranking;
	}

	public void setRank(String ranking) {
		this.ranking = ranking;
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

	
	
	
	
	
}
