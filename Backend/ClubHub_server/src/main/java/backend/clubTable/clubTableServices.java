package backend.clubTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clubTableServices {
	
	@Autowired
	private clubTableRepository clubTableRepository;
			
	public List<clubTable> getAllclubTable()
	{
		List<clubTable> clubtable = new ArrayList<>();
		clubTableRepository.findAll().forEach(clubtable::add);
		return clubtable;
	}
	
	public clubTable getclubTable(String clubtable)
	{
		return clubTableRepository.findOne(clubtable);
	}
	
	public void addclubTable( clubTable clubtable)
	{
		clubTableRepository.save(clubtable);
	}
	
	public void updateclubTable(String clubid, clubTable clubtable)
	{
		clubTableRepository.save(clubtable);

	}
	
	public void deleteclubTable(String clubtable)
	{
		clubTableRepository.delete(clubtable);

	}

}
