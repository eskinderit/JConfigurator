package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class StorageDaoTest {
	StorageDao storageDao;

	@BeforeEach
	void init() {
		storageDao = new StorageDao();
	}

	@Test
	void TestListAddition() throws JAXBException {
		ArrayList<Storage> storageListToAdd = new ArrayList<Storage>();
		ArrayList<Storage> localStorageList = storageDao.readComponents();

		Storage storage1 = new Storage("Storage1", 10, 10, 10, true);
		Storage storage2 = new Storage("Storage2", 10, 10, 10, true);

		storageListToAdd.add(storage1);
		storageListToAdd.add(storage2);
		localStorageList.add(storage1);
		localStorageList.add(storage2);

		ArrayList<Storage> listWithAdditions = storageDao.addComponents(storageListToAdd);

		assertEquals(localStorageList, listWithAdditions, "Addition storage list");

	}

	@Test
	void testRemoveList() throws JAXBException {
		ArrayList<Storage> storageListToRemove = new ArrayList<Storage>();
		ArrayList<Storage> localStorageList = storageDao.readComponents();

		Storage storage1 = new Storage();
		Storage storage2 = new Storage();

		storageListToRemove.add(storage1);
		storageListToRemove.add(storage2);

		localStorageList.removeAll(storageListToRemove);

		ArrayList<Storage> storageListWithRemoves = storageDao.deleteComponents(storageListToRemove);

		assertEquals(localStorageList, storageListWithRemoves, "Test delete storage list");

	}
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Storage> localstorageList = new ArrayList<Storage>();
		storageDao.setEmptyComponents();
		
		assertEquals(localstorageList, storageDao.readComponents(), "Empty Storage List");
	}

	@AfterEach
	void clearAll() throws JAXBException {
		storageDao.setDefaultComponents();
	}
}
