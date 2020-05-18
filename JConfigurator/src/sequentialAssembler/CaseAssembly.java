package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.FullConfig;
import dataSource.CaseDao;
import dataSource.ComponentDao;



public class CaseAssembly extends ComponentAssembly{

	@Override
	public	ComponentAssembly getPreviousPassage() {
		return new RamAssembly();
	}
	@Override
	public	ComponentAssembly getNextPassage() {
		return new StorageAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		CaseDao caseDao = new CaseDao(); 
		Case componentToSet = caseDao.getComponent(index);
		f1.setCase0(componentToSet);

	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new CaseDao();
	}
	@Override
	public ArrayList<Case> getCompatibleComponents(FullConfig f1) throws JAXBException {
		if(f1.getMotherboard() != null)
			return CompatibilityCheckAlgs.getCompatibleCasesByMotherboard(f1);
		else
		{
			CaseDao caseDao = new CaseDao();
			return caseDao.readComponents();
		}
	}
	
}
