package backend.userID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userIDController {

	@Autowired
	private userIDServices useridServices;

	@RequestMapping("/usersid")
	public users getAlluserID() {
		return new users(useridServices.getAlluserID());
	}

	@RequestMapping("/usersid/{netid}")
	public userID getuserID(@PathVariable String netid) {
		return useridServices.getuserID(netid);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/usersid")
	public void adduserID(@RequestBody userID userid) {
		useridServices.adduserID(userid);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/usersid/{netid}")
	public void updateuserID(@RequestBody userID userid, @PathVariable String netid) {
		useridServices.updateuserID(netid, userid);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/usersid/{netid}")
	public void deleteuserID(@PathVariable String netid) {
		useridServices.deleteuserID(netid);
	}

}
