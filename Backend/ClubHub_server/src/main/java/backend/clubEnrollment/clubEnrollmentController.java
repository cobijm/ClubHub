package backend.clubEnrollment;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class clubEnrollmentController {

	@Autowired
	private clubEnrollmentServices clubenrollmentServices;

	@RequestMapping("/clubEnrollment")
	public enrollment getAllclubEnrollment() {
		return new enrollment(clubenrollmentServices.getAllclubEnrollment());
	}

	@RequestMapping("/clubEnrollment/{enrollmentid}")
	public clubEnrollment getclubEnrollment(@PathVariable String clubenrollment) {
		return clubenrollmentServices.getclubEnrollment(clubenrollment);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/clubEnrollment")
	public void addclubEnrollment(@RequestBody clubEnrollment clubenrollment) {
		clubenrollmentServices.addclubEnrollment(clubenrollment);
	}

//	@RequestMapping(method = RequestMethod.PUT, path = "/clubEnrollment/{enrollmentid}")
//	public void updateclubEnrollment(@PathVariable String enrollmentid) {
//		clubenrollmentServices.updateclubEnrollment(enrollmentid);
//	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/clubEnrollment/{enrollmentid}")
	public void deleteclubEnrollment(@PathVariable String clubenrollment) {
		clubenrollmentServices.deleteclubEnrollment(clubenrollment);
	}

}
