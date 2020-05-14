package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageSelection implements ComponentSelection{
	private StorageDao storageList;
	private int size;
	
	public StorageSelection() throws JAXBException {
		storageList = new StorageDao();
		size = storageList.readComponents().size();
	}

	@Override
	public ArrayList<Storage> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		size = storageList.readComponents().size();
		return storageList.readComponents();
	}

	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}
