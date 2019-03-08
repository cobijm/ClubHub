package backend.userID;

import java.util.List;

public class users {
	private List<userID> users;

	public users(List<userID> users) {
		this.users = users;
	}

	public List<userID> getUser() {
		return users;
	}
}