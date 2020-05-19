package tests.shopDataManagementTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ConfiguratorEngine.Storage;
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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		storageList = storageDao.readComponents();
		storageData = new StorageDataManagement();
	}
	
	@Test
	public void deleteStorageTest() throws JAXBException {
		int index = (int)Math.random() * (storageDao.readComponents().size());
		assertNotEquals(storageData.deleteComp(index), storageList, " ");
		storageList.remove(index);
		assertEquals(storageDao.readComponents(), storageList, " ");
	}
	
	@Test
	public void addStorageTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		storageData.addComp(parameter);
		assertNotEquals(storageDao.readComponents(), storageList, " ");
		Storage storageToAdd = new Storage(storageData.name, storageData.price, storageData.power, storageData.capacity, storageData.ssd);
		storageList.add(storageToAdd);
		assertEquals(storageDao.readComponents(), storageList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetStoragesTest() throws JAXBException {
		assertEquals(storageData.resetComp(), storageDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		storageDao.setEmptyComponents();
		storageDao.addComponents(savedStorages);
	}
	
}