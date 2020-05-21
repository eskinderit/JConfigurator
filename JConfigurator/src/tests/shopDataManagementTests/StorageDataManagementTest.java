package tests.shopDataManagementTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Storage;
import dataSource.StorageDao;
import shopDataManagement.StorageDataManagement;


public class StorageDataManagementTest {
	static StorageDao storageDao = new StorageDao();
	static ArrayList<Storage> savedStorages = new ArrayList<Storage>();
	ArrayList<Storage> storageList;
	StorageDataManagement storageData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedStorages.addAll(storageDao.readComponents());
		
		Storage s = new Storage("Case1", 50, 50, 50, true);
		ArrayList<Storage> storageToAdd = new ArrayList<Storage>();
		storageToAdd.add(s);
		storageDao.addComponents(storageToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		
		
		storageList = storageDao.readComponents();
		storageData = new StorageDataManagement();
	}
	
	@Test
	public void deleteStorageTest() throws JAXBException {
		
		
		
		int index = (int)(Math.random() * storageDao.readComponents().size());
		assertNotEquals(storageData.deleteComp(index), storageList, "Makes sure that components in Storage.XML are not the same as before, after the deletion.");
		storageList.remove(index);
		assertEquals(storageDao.readComponents(), storageList, "Makes sure that the componenent was removed from Storage.XML file");
	}
	
	@Test
	public void addStorageTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		storageData.addComp(parameter);
		assertNotEquals(storageDao.readComponents(), storageList, "Makes sure that components in Storage.XML are not the same as before, after the addition.");
		Storage storageToAdd = new Storage(storageData.getName(), storageData.getPrice(), storageData.getPower(), storageData.getCapacity(), storageData.isSsd());
		storageList.add(storageToAdd);
		assertEquals(storageDao.readComponents(), storageList, "Makes sure that the componenent was added in Storage.XML file");
		parameter.close();
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		storageDao.setEmptyComponents();
		storageDao.addComponents(savedStorages);
	}
	
}