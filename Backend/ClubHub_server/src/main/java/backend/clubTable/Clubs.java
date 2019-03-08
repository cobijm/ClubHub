package backend.clubTable;

import java.util.List;

public class Clubs {
	private List<clubTable> Clubs;

	public Clubs(List<clubTable> Clubs) {
		this.Clubs = Clubs;
	}

	public List<clubTable> getClubs() {
		return Clubs;
	}
}