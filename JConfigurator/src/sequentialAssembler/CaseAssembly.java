package sequentialAssembler;

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
		f1.setMyCase1(componentToSet);
		
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new CaseDao();
	}
	
}
