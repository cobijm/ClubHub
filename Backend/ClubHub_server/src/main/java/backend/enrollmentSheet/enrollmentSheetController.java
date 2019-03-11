package backend.enrollmentSheet;

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
public class enrollmentSheetController {

	@Autowired
	private enrollmentSheetServices enrollmentsheetServices;

	@RequestMapping("/enrollmentsheet")
	public Enrollments getAllenrollmentSheet() {
		return new Enrollments(enrollmentsheetServices.getAllenrollmentSheet());
	}

	@RequestMapping("/enrollmentsheet/{netid}")
	public enrollmentSheet getenrollmentSheet(@PathVariable String netid) {
		return enrollmentsheetServices.getenrollmentSheet(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/enrollmentsheet")
	public void addenrollmentSheet(@RequestBody enrollmentSheet enrollmentsheet) {
		enrollmentsheetServices.addenrollmentSheet(enrollmentsheet);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/enrollmentsheet/{netid}")
	public void updateenrollmentSheet(@RequestBody enrollmentSheet enrollmentsheet, @PathVariable String netid) {
		enrollmentsheetServices.updateenrollmentSheet(netid, enrollmentsheet);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/enrollmentsheet/{netid}")
	public void deleteenrollmentSheet(@PathVariable String netid) {
		enrollmentsheetServices.deleteenrollmentSheet(netid);
	}

}
