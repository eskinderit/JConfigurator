package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.Case;
import configuratorEngine.FullConfig;
import dataSource.CaseDao;

public class CaseAssembly extends ComponentAssembly<Case> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		CaseDao caseDao = new CaseDao();
		Case componentToSet = caseDao.getComponent(index);
		f1.setCase0(componentToSet);

	}

	@Override
	public ArrayList<Case> getCompatibleComponents(FullConfig f1) throws JAXBException {
		if (f1.getMotherboard() != null)
			return this.getCompatibleCasesByMotherboard(f1);
		else {
			CaseDao caseDao = new CaseDao();
			return caseDao.readComponents();
		}
	}

	private ArrayList<Case> getCompatibleCasesByMotherboard(FullConfig f1) throws JAXBException {
		ArrayList<Case> compatibleCases = new ArrayList<Case>();
		CaseDao caseDao = new CaseDao();
		for (Case c : caseDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardCase(f1.getMotherboard(), c))
				compatibleCases.add(c);
		}
		return compatibleCases;
	}

}
