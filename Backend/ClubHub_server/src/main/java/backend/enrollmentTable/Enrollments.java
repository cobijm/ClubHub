package backend.enrollmentTable;

import java.util.List;

public class Enrollments {
	private List<enrollmentTable> Enrollments;

	public Enrollments(List<enrollmentTable> Enrollments) {
		this.Enrollments = Enrollments;
	}

	public List<enrollmentTable> getEnrollments() {
		return Enrollments;
	}
}