package sequentialAssembler;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Storage;
import dataSource.ComponentDao;
import dataSource.StorageDao;

public class StorageAssembly extends ComponentAssembly{
	@Override
public	ComponentAssembly getPreviousPassage() {
		return new CaseAssembly();
	}
	@Override
public	ComponentAssembly getNextPassage() {
		return new PsuAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		StorageDao storageDao = new StorageDao(); 
		Storage componentToSet = storageDao.getComponent(index);
		f1.setMyStorage(componentToSet);
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new StorageDao();
	}	
}
