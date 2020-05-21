package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import configuratorEngine.Storage;
import dataSource.ComponentDao;
import dataSource.StorageDao;

public class StorageDataManagement extends ComponentDataManagement<Storage>{

	private StorageDao storageDao = new StorageDao();
	
	private ArrayList<Storage> storages = new ArrayList<Storage>();
	private int capacity;
	private boolean ssd = false;
	
	

	@Override
	public ArrayList<Storage> deleteComp(int index) throws JAXBException {
		
		storages.add(storageDao.getComponent(index));
		return storageDao.deleteComponents(storages);
	}

	@Override
	public ArrayList<Storage> addComp(Scanner parameter) throws JAXBException {
		String input;
		
		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		
		do {
			System.out.println("Capacity: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		capacity = Integer.parseInt(input);
		
		do {
			System.out.println("SSD?: ");
			System.out.println("A) Si   B) No");
			input = parameter.nextLine();
		}while(!(input.contains("a") || input.contains("b")));
		
		Storage storage;
		if(input.contains("a")) {
			ssd = true;
			storage = new Storage(getName(), getPrice(), getPower(), capacity, ssd);
		}
		else {
			ssd = false;
			storage = new Storage(getName(), getPrice(), getPower(), capacity, ssd);
		}
		
		storages.add(storage);
		return storageDao.addComponents(storages);
	}

	@Override
	public ArrayList<Storage> resetComp() throws JAXBException {
		return storageDao.setDefaultComponents();
	}
	
	
	/**
	 * Getters and setters of remaining Storage parameters (capacity, ssd)
	 */

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	@Override
	public ComponentDao<Storage, ?> getComponentDao() {
		return storageDao;
	}

}
