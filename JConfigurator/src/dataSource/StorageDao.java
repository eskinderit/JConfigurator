package dataSource;
import java.util.ArrayList;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import ConfiguratorEngine.Storage;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StorageDao extends ComponentDao<Storage, StorageDao>{
	@XmlElement(name="Storage")
	private ArrayList<Storage> storageList;
	

	
	@Override
	public ArrayList<Storage> getComponentList() {
		return storageList;
	}

	@Override
	public ArrayList<Storage> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> addComponents(ArrayList<Storage> toAddList) throws JAXBException{
		return this._addComponents ("src/dataSource/xmlSource/Storage.Xml",toAddList, StorageDao.class);
	}
	
	@Override
	public ArrayList<Storage> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/StorageDefault.Xml","src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
	}


}
