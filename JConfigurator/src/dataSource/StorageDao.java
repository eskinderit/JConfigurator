package dataSource;
import java.util.ArrayList;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import ConfiguratorEngine.Storage;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StorageDao extends ComponentDao<Storage>{
	@XmlElement(name="Storage")
	private ArrayList<Storage> storageList;
	

	
	@Override
	public ArrayList<Storage> getComponentList() {
		return storageList;
	}

	@Override
	public ArrayList<Storage> readComponents() throws JAXBException{
		return this.<StorageDao>_readComponents ("src/dataSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<StorageDao>_removeComponents (toDeleteList,"src/dataSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> addComponents(ArrayList<Storage> toAddList) throws JAXBException{
		return this.<StorageDao>_addComponents ("src/dataSource/Storage.Xml",toAddList, StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> setDefaultComponents() throws JAXBException {
		return this.<StorageDao>_setDefaultComponents("src/dataSource/StorageDefault.Xml","src/dataSource/Storage.Xml", StorageDao.class);
	}


}
