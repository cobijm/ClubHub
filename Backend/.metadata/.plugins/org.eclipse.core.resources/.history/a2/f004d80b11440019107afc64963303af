package backend.clubEnrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class clubEnrollmentController {
	
	@Autowired
	private clubEnrollmentServices clubenrollmentServices;
	
	@RequestMapping("/clubenrollment")
	public enrollments getAllclubEnrollment() {
		return new enrollments(clubenrollmentServices.getAllclubEnrollment());
	}

	@RequestMapping("/clubenrollment/{netid}")
	public clubEnrollment getclubEnrollment(@PathVariable String netid) {
		return clubenrollmentServices.getclubEnrollment(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/clubenrollment")
	public void addclubEnrollment(@RequestBody clubEnrollment clubenrollment) {
		clubenrollmentServices.addclubEnrollment(clubenrollment);
	}

//	@RequestMapping(method = RequestMethod.PUT, path = "/clubenrollment/{netid}")
//	public void updateclubTable(@RequestBody clubTable clubtable, @PathVariable String netid) {
//		clubenrollmentServices.updateclubTable(netid, clubtable);
//	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/clubenrollment/{netid}")
	public void deleteclubEnrollment(@PathVariable String netid) {
		clubenrollmentServices.deleteclubEnrollment(netid);
	}
	

}
