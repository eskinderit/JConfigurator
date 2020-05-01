package sequentialAssembler;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageAssembly extends ComponentAssembly{
	ComponentAssembly getPrevoiusPassage() {
		return new CaseAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new PsuAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		StorageDao storageDao = new StorageDao(); 
		Storage componentToSet = storageDao.getComponent(index);
		f1.setMyStorage(componentToSet);
	}

}
