package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Storage> deleteComp(int index) throws JAXBException {
		ArrayList<Storage> storages = new ArrayList<Storage>();
		StorageDao storageDao = new StorageDao();
		storages.add(storageDao.getComponent(index));
		return storageDao.deleteComponents(storages);
	}

}
