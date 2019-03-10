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
	
	public clubTable getclubTable(String netid)
	{
		return clubTableRepository.findOne(netid);
	}
	
	public void addclubTable( clubTable clubtable)
	{
		clubTableRepository.save(clubtable);
	}
	
	public void updateclubTable(String netid, clubTable clubtable)
	{
		clubTableRepository.save(clubtable);

	}
	
	public void deleteclubTable(String netid)
	{
		clubTableRepository.delete(netid);

	}

}
