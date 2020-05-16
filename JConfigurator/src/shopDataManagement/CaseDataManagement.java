package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Case;
import dataSource.CaseDao;


public class CaseDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Case> deleteComp(int index) throws JAXBException {
		ArrayList<Case> cases = new ArrayList<Case>();
		CaseDao caseDao = new CaseDao();
		cases.add(caseDao.readComponents().get(index));
		return caseDao.deleteComponents(cases);
	}

}
