package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageDataManagement extends ComponentDataManagement<Storage>{

	private ArrayList<Storage> storages = new ArrayList<Storage>();
	private String name = null;
	private int price = 0; 
	private int power = 0;
	private int capacity;
	private boolean ssd = false;
	
	

	@Override
	public ArrayList<Storage> deleteComp(int index) throws JAXBException {
		
		StorageDao storageDao = new StorageDao();
		storages.add(storageDao.getComponent(index));
		return storageDao.deleteComponents(storages);
	}

	@Override
	public ArrayList<Storage> addComp(Scanner parameter) throws JAXBException {
		String input;
		StorageDao storageDao = new StorageDao();
		
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
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
			storage = new Storage(name, price, power, capacity, ssd);
		}
		else {
			ssd = false;
			storage = new Storage(name, price, power, capacity, ssd);
		}
		
		storages.add(storage);
		return storageDao.addComponents(storages);
	}

	@Override
	public ArrayList<Storage> resetComp() throws JAXBException {
		StorageDao storageDao = new StorageDao();
		return storageDao.setDefaultComponents();
	}
	
	
	// GETTERS AND SETTERS
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

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

}
