package backend.enrollmentTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "EnrollmentTable")
public class enrollmentTable {

	@Id
	private String enrollmentID;
	private String studentID;
	private String rank;
	private String joinDate;
	private String expirationDate;
	private String clubStanding;


		
	public enrollmentTable() {

	}


	public enrollmentTable( String enrollmentid, String studentid, String rank, String joindate,
			String expirationdate, String clubstanding) {
		super();

		this.enrollmentID = enrollmentid;
		this.studentID = studentid;
		this.rank = rank;
		this.joinDate = joindate;
		this.expirationDate = expirationdate;
		this.clubStanding = clubstanding;
	}


	public String getEnrollmentID() {
		return enrollmentID;
	}


	public void setEnrollmentID(String enrollmentID) {
		this.enrollmentID = enrollmentID;
	}


	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
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


	
}