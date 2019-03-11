package backend.userID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "UserID")
public class userID {

	@Id
	private String studentID;
	private String netID;
	private String firstName;
	private String lastName;
	private String classification;
	private String phoneNumber;
	private String major;
	private String password;

	public userID() {

	}

	public userID(String studentid, String netid, String firstname, String lastname, String classification, String phonenumber, String major, String password) {
		super();

		this.studentID = studentid;
		this.netID = netid;
		this.firstName = firstname;
		this.lastName = lastname;
		this.classification = classification;
		this.phoneNumber = phonenumber;
		this.major = major;
		this.password = password;

	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getNetID() {
		return netID;
	}

	public void setNetID(String netID) {
		this.netID = netID;
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

