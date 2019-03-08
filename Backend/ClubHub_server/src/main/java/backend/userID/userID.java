package backend.userID;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserID")
public class userID {

	@Id
	private String studentid;
	private String netid;
	private String firstName;
	private String lastName;
	private String classification;
	private String phoneNumber;
	private String major;
	private String password;

	public userID() {

	}

	public userID(String studentid, String netid, String firstName, String lastName, String classification, 
			String phoneNumber, String major, String password) {
		super();

		this.studentid = studentid;
		this.netid = netid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classification = classification;
		this.phoneNumber = phoneNumber;
		this.major = major;;
		this.password = password;

	}

	public String getId() {
		return studentid;
	}

	public void setId(String studentid) {
		this.studentid = studentid;
	}
	
	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}