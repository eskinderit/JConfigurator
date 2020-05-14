package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.FullConfigBuilder;
import dataSource.CaseDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class CaseSelection implements ComponentSelection{
	private CaseDao caseList;
	private int size;
	
	public CaseSelection() throws JAXBException {
		caseList = new CaseDao();
		size = caseList.readComponents().size();
	}
	
	
	@Override
	public ArrayList<Case> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Case> cases = new ArrayList<Case>();
		if(f.getMyMotherboard() != null)
			cases=CompatibilityCheckAlgs.getCompatibleCasesByMotherboard(f);
		else
			cases = caseList.readComponents();
		
		size = cases.size();
		return cases;
	}

	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}
