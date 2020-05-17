package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Storage;
import dataSource.CaseDao;
import dataSource.StorageDao;

public class StorageDataManagement extends ComponentDataManagement{

	private ArrayList<Storage> storages = new ArrayList<Storage>();
	
	@Override
	public ArrayList<Storage> deleteComp(int index) throws JAXBException {
		
		StorageDao storageDao = new StorageDao();
		storages.add(storageDao.getComponent(index));
		return storageDao.deleteComponents(storages);
	}

	@Override
	public ArrayList<Storage> addComp() throws JAXBException {
		String input;
		StorageDao storageDao = new StorageDao();
		
		String name;
		int price; 
		int power;
		int capacity;
		Boolean ssd;
		
		Scanner parameter = new Scanner(System.in);
		System.out.println("Nome: ");
		name = parameter.nextLine();
		
		do {
			System.out.println("Prezzo: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		price = Integer.parseInt(input);
		
		do {
			System.out.println("Potenza: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		power = Integer.parseInt(input);
		
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
		if(input.contains("a"))
			storage = new Storage(name, price, power, capacity, true);
		else
			storage = new Storage(name, price, power, capacity, false);
		
		storages.add(storage);
		return storageDao.addComponents(storages);
	}

}
