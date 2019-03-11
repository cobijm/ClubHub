package backend.enrollmentTable;

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
public class enrollmentTableController {

	@Autowired
	private enrollmentTableServices enrollmenttableServices;

	@RequestMapping("/enrollmenttable")
	public Enrollments getAllenrollmentTable() {
		return new Enrollments(enrollmenttableServices.getAllenrollmentTable());
	}

	@RequestMapping("/enrollmenttable/{netid}")
	public enrollmentTable getenrollmentTable(@PathVariable String netid) {
		return enrollmenttableServices.getenrollmentTable(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/enrollmenttable")
	public void addenrollmentTable(@RequestBody enrollmentTable enrollmenttable) {
		enrollmenttableServices.addenrollmentTable(enrollmenttable);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/enrollmenttable/{netid}")
	public void updateenrollmentTable(@RequestBody enrollmentTable enrollmenttable, @PathVariable String netid) {
		enrollmenttableServices.updateenrollmentTable(netid, enrollmenttable);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/enrollmenttable/{netid}")
	public void deleteenrollmentTable(@PathVariable String netid) {
		enrollmenttableServices.deleteenrollmentTable(netid);
	}

}
