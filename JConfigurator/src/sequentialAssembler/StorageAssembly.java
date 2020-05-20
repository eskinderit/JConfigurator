package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.FullConfig;
import configuratorEngine.Storage;
import dataSource.StorageDao;

public class StorageAssembly extends ComponentAssembly<Storage> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		StorageDao storageDao = new StorageDao();
		Storage componentToSet = storageDao.getComponent(index);
		f1.setStorage(componentToSet);
	}

	@Override
	public ArrayList<Storage> getCompatibleComponents(FullConfig f1) throws JAXBException {

		StorageDao storageDao = new StorageDao();
		return storageDao.readComponents();

	}
}
