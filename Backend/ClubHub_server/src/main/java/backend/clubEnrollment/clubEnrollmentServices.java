package backend.clubEnrollment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class clubEnrollmentServices {

	@Autowired
	private clubEnrollmentRepository clubenrollmentRepository;
			
	public List<clubEnrollment> getAllclubEnrollment()
	{
		List<clubEnrollment> clubenrollment = new ArrayList<>();
		clubenrollmentRepository.findAll().forEach(clubenrollment::add);
		return clubenrollment;
	}
	
	public clubEnrollment getclubEnrollment(String enrollmentid)
	{
		return clubenrollmentRepository.findOne(enrollmentid);
	}
	
	public void addclubEnrollment( clubEnrollment enrollmentid)
	{
		clubenrollmentRepository.save(enrollmentid);
	}
	
//	public void updateclubEnrollment(String enrollmentid)
//	{
//		clubenrollmentRepository.save(enrollmentid);
//
//	}
	
	public void deleteclubEnrollment(String enrollmentid)
	{
		clubenrollmentRepository.delete(enrollmentid);

	}
	
}
