package backend.enrollmentSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class enrollmentSheetServices {
	
	@Autowired
	private enrollmentSheetRepository enrollmentSheetRepository;
			
	public List<enrollmentSheet> getAllenrollmentSheet()
	{
		List<enrollmentSheet> enrollmentsheet = new ArrayList<>();
		enrollmentSheetRepository.findAll().forEach(enrollmentsheet::add);
		return enrollmentsheet;
	}
	
	public enrollmentSheet getenrollmentSheet(String netid)
	{
		return enrollmentSheetRepository.findOne(netid);
	}
	
	public void addenrollmentSheet( enrollmentSheet enrollmentsheet)
	{
		enrollmentSheetRepository.save(enrollmentsheet);
	}
	
	public void updateenrollmentSheet(String netid, enrollmentSheet enrollmentsheet)
	{
		enrollmentSheetRepository.save(enrollmentsheet);

	}
	
	public void deleteenrollmentSheet(String netid)
	{
		enrollmentSheetRepository.delete(netid);

	}

}
