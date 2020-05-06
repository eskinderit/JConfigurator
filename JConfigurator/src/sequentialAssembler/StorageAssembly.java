package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Storage;
import dataSource.ComponentDao;
import dataSource.StorageDao;

public class StorageAssembly extends ComponentAssembly {
	@Override
	public	ComponentAssembly getPreviousPassage() {
		return new CaseAssembly();
	}
	@Override
	public	ComponentAssembly getNextPassage() {
		return new PsuAssembly();
	}

	@Override
	protected void passageBehavior(FullConfigBuilder f1, int index) throws JAXBException {
		StorageDao storageDao = new StorageDao(); 
		Storage componentToSet = storageDao.getComponent(index);
		f1.storage(componentToSet);
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new StorageDao();
	}
	@Override
	public ArrayList<Storage> getCompatibleComponents(FullConfigBuilder f1) throws JAXBException {

		StorageDao storageDao = new StorageDao();
		return storageDao.readComponents();

	}	
}
