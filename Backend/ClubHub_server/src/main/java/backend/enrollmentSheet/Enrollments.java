package backend.enrollmentSheet;

import java.util.List;

public class Enrollments {
	private List<enrollmentSheet> Enrollments;

	public Enrollments(List<enrollmentSheet> Enrollments) {
		this.Enrollments = Enrollments;
	}

	public List<enrollmentSheet> getEnrollments() {
		return Enrollments;
	}
}