package backend.clubTable;

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
public class clubTableController {

	@Autowired
	private clubTableServices clubtableServices;

	@RequestMapping("/clubtable")
	public clubs getAllclubTable() {
		return new clubs(clubtableServices.getAllclubTable());
	}

	@RequestMapping("/clubtable/{netid}")
	public clubTable getclubTable(@PathVariable String netid) {
		return clubtableServices.getclubTable(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/clubtable")
	public void addclubTable(@RequestBody clubTable clubtable) {
		clubtableServices.addclubTable(clubtable);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/clubtable/{netid}")
	public void updateclubTable(@RequestBody clubTable clubtable, @PathVariable String netid) {
		clubtableServices.updateclubTable(netid, clubtable);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/clubtable/{netid}")
	public void deleteclubTable(@PathVariable String netid) {
		clubtableServices.deleteclubTable(netid);
	}

}
