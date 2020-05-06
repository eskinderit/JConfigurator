package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Case;

import ConfiguratorEngine.FullConfigBuilder;

import dataSource.CaseDao;


public class SelectCase extends SelectComponent {
private CaseDao caseDao;
	
	public SelectCase() {
		caseDao = new CaseDao();
	}

	@Override
	public void readComponent() throws JAXBException {
		System.out.println("Select a case from list: ");
		for(Case c:caseDao.readComponents()) {
			System.out.println(c);
		}
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		Case c = caseDao.readComponents().get(n);
		f.case1(c);
	}

	@Override
	public ArrayList<Case> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Case> caseList = new ArrayList<Case>();
		if(f.getMyMotherboard() != null) {
			for(Case c:caseDao.readComponents()) {
				if(f.getMyMotherboard().getSize() <= c.getSize())
					caseList.add(c);
			}
		}
		else
			caseList = caseDao.readComponents();
		System.out.println("Select case from list:\n");
		for(Case c:caseList) {
			System.out.println(c);
		}
		return caseList;
	}
}
