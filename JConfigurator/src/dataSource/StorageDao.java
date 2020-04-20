package dataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StorageDao extends ComponentDao{
	@XmlElement(name="Storage")
	private ArrayList<Storage> storageList;
	

	
	@Override
	public ArrayList<Storage> getComponentList() {
		return storageList;
	}

	@Override
	public ArrayList<Storage> readComponents() throws JAXBException{
		return ComponentDao.<Storage, StorageDao>_readComponents ("src/dataSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> deleteComponents(int toDeleteList[]) throws JAXBException{
		return ComponentDao.<Storage,StorageDao>_removeComponents (toDeleteList,"src/dataSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> addComponents(ArrayList toAddList) throws JAXBException{
		return ComponentDao.<Storage,StorageDao>_addComponents ("src/dataSource/Storage.Xml",toAddList, StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> setDefaultComponents() throws JAXBException {
		return ComponentDao.<Storage,StorageDao>_setDefaultComponents("src/dataSource/StorageDefault.Xml","src/dataSource/Storage.Xml", StorageDao.class);
	}


}
