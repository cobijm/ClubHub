package backend.userID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class userIDController {

	@Autowired
	private userIDServices useridServices;

	@RequestMapping("/usersid")
	public List<userID> getAlluserID() {
		return useridServices.getAlluserID();
		
	}

	@RequestMapping("/usersid/{id}")
	public userID getuserID(@PathVariable String id) {
		return useridServices.getuserID(id);

	}

	@RequestMapping(method = RequestMethod.POST, path = "/usersid")
	public void adduserID(@RequestBody userID userid) {
		useridServices.adduserID(userid);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/usersid/{id}")
	public void updateuserID(@RequestBody userID userid, @PathVariable String id) {
		useridServices.adduserID(userid);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/usersid/{id}")
	public void deleteuserID(@PathVariable String id) {
		useridServices.deleteuserID(id);
	}

}
