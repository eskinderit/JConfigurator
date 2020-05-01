package sequentialAssembler;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.FullConfig;
import dataSource.CaseDao;


public class CaseAssembly extends ComponentAssembly{

	ComponentAssembly getPrevoiusPassage() {
		return new RamAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new StorageAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		CaseDao caseDao = new CaseDao(); 
		Case componentToSet = caseDao.getComponent(index);
		f1.setMyCase1(componentToSet);
		
	}

	
}
