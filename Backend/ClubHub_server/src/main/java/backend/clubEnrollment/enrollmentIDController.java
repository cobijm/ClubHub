package backend.clubEnrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class enrollmentIDController {

	@Autowired
	private enrollmentIDServices enrollmentidServices;

	@RequestMapping("/enrollmentsid")
	public enrollments getAllenrollmentID() {
		return new enrollments(enrollmentidServices.getAllenrollmentID());
	}

	@RequestMapping("/enrollmentsid/{netid}")
	public enrollmentID getenrollmentID(@PathVariable String netid) {
		return enrollmentidServices.getenrollmentID(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/enrollmentsid")
	public void addenrollmentID(@RequestBody enrollmentID enrollmentid) {
		enrollmentidServices.addenrollmentID(enrollmentid);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/enrollmentsid/{netid}")
	public void updateenrollmentID(@RequestBody enrollmentID enrollmentid, @PathVariable String netid) {
		enrollmentidServices.updateenrollmentID(netid, enrollmentid);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/enrollmentsid/{netid}")
	public void deleteenrollmentID(@PathVariable String netid) {
		enrollmentidServices.deleteenrollmentID(netid);
	}

}
