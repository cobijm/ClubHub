package backend.clubEnrollment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class enrollmentIDServices {
	
	@Autowired
	private enrollmentIDRepository enrollmentsidRepository;
			
	public List<enrollmentID> getAllenrollmentID()
	{
		List<enrollmentID> enrollmentsid = new ArrayList<>();
		enrollmentsidRepository.findAll().forEach(enrollmentsid::add);
		return enrollmentsid;
	}
	
	public enrollmentID getenrollmentID(String netid)
	{
		return enrollmentsidRepository.findOne(netid);
	}
	
	public void addenrollmentID( enrollmentID enrollmentid)
	{
		enrollmentsidRepository.save(enrollmentid);
	}
	
	public void updateenrollmentID(String netid, enrollmentID enrollmentid)
	{
		enrollmentsidRepository.save(enrollmentid);

	}
	
	public void deleteenrollmentID(String netid)
	{
		enrollmentsidRepository.delete(netid);

	}

}
