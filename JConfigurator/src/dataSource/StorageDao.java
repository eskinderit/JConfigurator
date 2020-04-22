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
		return this.storageList;
	}

	@Override
	public ArrayList<Storage> readComponents() throws JAXBException{
		this.storageList = this._readComponents ("src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}
	
	@Override
	public ArrayList<Storage> deleteComponents(ArrayList<Storage> toDeleteList) throws JAXBException{
		this.storageList = this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}
	
	@Override
	public ArrayList<Storage> addComponents(ArrayList<Storage> toAddList) throws JAXBException{
		this.storageList = this._addComponents ("src/dataSource/xmlSource/Storage.Xml",toAddList, StorageDao.class);
		return this.storageList;
	}
	
	@Override
	public ArrayList<Storage> setDefaultComponents() throws JAXBException {
		this.storageList = this._setDefaultComponents("src/dataSource/xmlSource/StorageDefault.Xml","src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}


}
