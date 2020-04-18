package dataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import ConfiguratorEngine.Storage;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StorageDao {
	@XmlElement(name="storage")
	private ArrayList<Storage> storage;
	
	
	public StorageDao(ArrayList<Storage> storage) {
		super();
		storage=new ArrayList<Storage>();
		this.storage = storage;
	}
	
	public StorageDao() {
		super();
		storage=new ArrayList<Storage>();
	}

	private ArrayList<Storage> getStorageList() {
		return this.storage;
	}

	/*public void setStorageList(ArrayList<Storage> storage) {
		this.storage = storage;
	}*/
	
	private void addStorageList(ArrayList<Storage>storageList) {
		storage.addAll(storageList);
	}
	
	
	
	static {
		
		Storage storage1 = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);
		Storage storage2 = new Storage("Samsung 850 evo 500GB (SSD)", 153, 10, 500, true);
		Storage storage3 = new Storage("Samsung 850 evo 250GB (SSD)", 153, 10, 250, true);
		Storage storage4 = new Storage("WD Black 2TB (HDD)", 130, 10, 2000, false);
		Storage storage5 = new Storage("WD Black 1TB (HDD)", 79, 10, 1000, false);
		ArrayList<Storage> al = new ArrayList<Storage>();
		al.add(storage1);
		al.add(storage2);
		al.add(storage3);
		al.add(storage4);
		al.add(storage5);
	}
	
	
	public ArrayList<Storage> setStorageFile() throws JAXBException {

		StorageDao storageDao=new StorageDao();
		JAXBContext context=JAXBContext.newInstance(StorageDao.class);
		Marshaller mrs=context.createMarshaller();
		mrs.marshal(storageDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.xml"));

		return storageDao.getStorageList();
	}
	
	public ArrayList<Storage> readStorages() throws JAXBException{

		JAXBContext context=JAXBContext.newInstance(StorageDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		StorageDao storageDao = (StorageDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.Xml"));

		return storageDao.getStorageList();
	}
	
	public void setDefaultStorageFile() throws JAXBException {
		
		JAXBContext context=JAXBContext.newInstance(StorageDao.class);
		
		Unmarshaller ums=context.createUnmarshaller();
		StorageDao storageDao = (StorageDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\StorageDefault.Xml"));
		
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(storageDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.Xml"));
	}
	
	
	
	public ArrayList<Storage> addStorages(ArrayList<Storage>StorageToAdd) throws JAXBException{
		StorageDao storageDao=new StorageDao();
		JAXBContext context=JAXBContext.newInstance(StorageDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		storageDao = (StorageDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.Xml"));
		
		storageDao.addStorageList(StorageToAdd);
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		mrs.marshal(storageDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.Xml"));
		return storageDao.getStorageList();
	}
	
	public ArrayList<Storage> removeStorages(int storagesToRemove[]) throws JAXBException{

		JAXBContext context=JAXBContext.newInstance(StorageDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		StorageDao storageDao =(StorageDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.xml"));

		Arrays.sort(storagesToRemove);

		for(int i=0; i<storagesToRemove.length; i++) {
			for (int j=0; j<storageDao.getStorageList().size(); j++) {
				if(storagesToRemove[i]==j) {
					storageDao.getStorageList().remove(j);
					for(int k=i; k<storagesToRemove.length; k++) {
						storagesToRemove[k]=storagesToRemove[k]-1;
					}
				}
			}
		}
		
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		mrs.marshal(storageDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Storage.Xml"));
		return storageDao.getStorageList();
	}
	
}
