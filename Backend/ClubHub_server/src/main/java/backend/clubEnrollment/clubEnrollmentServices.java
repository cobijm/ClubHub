package backend.clubEnrollment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clubEnrollmentServices {
	
	@Autowired
	private clubEnrollmentRepository clubEnrollmentRepository;
			
	public List<clubEnrollment> getAllclubEnrollment()
	{
		List<clubEnrollment> clubenrollment = new ArrayList<>();
		clubEnrollmentRepository.findAll().forEach(clubenrollment::add);
		return clubenrollment;
	}
	
	public clubEnrollment getclubEnrollment(String netid)
	{
		return clubEnrollmentRepository.findOne(netid);
	}
	
	public void addclubEnrollment( clubEnrollment clubenrollment)
	{
		clubEnrollmentRepository.save(clubenrollment);
	}
	
//	public void updateclubEnrollment(String netid, clubEnrollment clubenrollment)
//	{
//		clubEnrollmentRepository.save(clubenrollment);
//
//	}
	
	public void deleteclubEnrollment(String netid)
	{
		clubEnrollmentRepository.delete(netid);

	}
	
	
	
	

}
