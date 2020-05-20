package tests.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageDaoTest {
	StorageDao storageDao;
	ArrayList<Storage> storageList;
	Storage storage1;
	Storage storage2;

	@BeforeEach
	void init() {
		storageDao = new StorageDao();
		storageList = new ArrayList<Storage>();
		storage1 = new Storage("Storage1", 10, 10, 10, true);
		storage2 = new Storage("Storage2", 10, 10, 10, true);
		storageList.add(storage1);
		storageList.add(storage2);
	}

	@Test
	void testAddComponents() throws JAXBException {
		ArrayList<Storage> localStorageList = storageDao.readComponents();
		localStorageList.addAll(storageList);

		storageDao.addComponents(storageList);

		assertEquals(localStorageList, storageDao.readComponents(), "Add a storage list");
	}

	@Test
	void testAddComponents_repeated() throws JAXBException {
		ArrayList<Storage> localstorageList = storageDao.readComponents();

		localstorageList.addAll(storageList);
		storageDao.addComponents(storageList);
		storageDao.addComponents(storageList);
		assertEquals(localstorageList, storageDao.readComponents(), "Can only add the same storageList once");
		storageDao.addComponents(storageList);
		localstorageList.addAll(storageList);
		assertNotEquals(localstorageList, storageDao.readComponents(), "Can only add the same storageList once");
	}

	@Test
	void testDeleteComponents() throws JAXBException {
		ArrayList<Storage> localStorageList = storageDao.readComponents();
		localStorageList.removeAll(storageList);

		storageDao.deleteComponents(storageList);

		assertEquals(localStorageList, storageDao.readComponents(), "Remove a storage list");

	}

	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Storage> localstorageList = new ArrayList<Storage>();
		storageDao.setEmptyComponents();

		assertEquals(localstorageList, storageDao.readComponents(), "Set an empty Storage List");

	}

	void testAddOnEmptyFile() throws JAXBException {
		storageDao.setEmptyComponents();
		storageDao.addComponents(storageList);

		assertEquals(storageDao.readComponents(), storageList, "Add elements on an empty file");

	}

	@AfterEach
	void clearAll() throws JAXBException {
		storageDao.setDefaultComponents();
	}
}