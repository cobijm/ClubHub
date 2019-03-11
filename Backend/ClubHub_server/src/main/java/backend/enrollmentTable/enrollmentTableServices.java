package backend.enrollmentTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class enrollmentTableServices {
	
	@Autowired
	private enrollmentTableRepository enrollmentTableRepository;
			
	public List<enrollmentTable> getAllenrollmentTable()
	{
		List<enrollmentTable> enrollmenttable = new ArrayList<>();
		enrollmentTableRepository.findAll().forEach(enrollmenttable::add);
		return enrollmenttable;
	}
	
	public enrollmentTable getenrollmentTable(String netid)
	{
		return enrollmentTableRepository.findOne(netid);
	}
	
	public void addenrollmentTable( enrollmentTable enrollmenttable)
	{
		enrollmentTableRepository.save(enrollmenttable);
	}
	
	public void updateenrollmentTable(String netid, enrollmentTable enrollmenttable)
	{
		enrollmentTableRepository.save(enrollmenttable);

	}
	
	public void deleteenrollmentTable(String netid)
	{
		enrollmentTableRepository.delete(netid);

	}

}
