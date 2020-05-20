package dataSource;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import configuratorEngine.Storage;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StorageDao extends ComponentDao<Storage, StorageDao> {

	public StorageDao() {
		super();
		this.storageList = new ArrayList<Storage>();
	}

	@XmlElement(name = "Storage")
	private ArrayList<Storage> storageList;

	@Override
	protected ArrayList<Storage> getComponentList() {
		return this.storageList;
	}

	@Override
	protected void setComponentList(ArrayList<Storage> componentList) {
		this.storageList = componentList;
	}

	@Override
	public ArrayList<Storage> readComponents() throws JAXBException {
		this.storageList = this._readComponents("src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}

	@Override
	public ArrayList<Storage> deleteComponents(ArrayList<Storage> toDeleteList) throws JAXBException {
		this.storageList = this._removeComponents(toDeleteList, "src/dataSource/xmlSource/Storage.Xml",
				StorageDao.class);
		return this.storageList;
	}

	@Override
	public ArrayList<Storage> addComponents(ArrayList<Storage> toAddList) throws JAXBException {
		this.storageList = this._addComponents("src/dataSource/xmlSource/Storage.Xml", toAddList, StorageDao.class);
		return this.storageList;
	}

	@Override
	public ArrayList<Storage> setDefaultComponents() throws JAXBException {
		this.storageList = this._setDefaultComponents("src/dataSource/xmlSource/StorageDefault.Xml",
				"src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}

	@Override
	public ArrayList<Storage> setEmptyComponents() throws JAXBException {
		this.storageList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyStorage.Xml",
				"src/dataSource/xmlSource/Storage.Xml", StorageDao.class);
		return this.storageList;
	}

}
