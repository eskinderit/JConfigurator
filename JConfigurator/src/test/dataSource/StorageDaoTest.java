package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

import dataSource.StorageDao;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Storage;

public class StorageDaoTest {
	StorageDao storageDao;

	@BeforeEach
	void init() {
		storageDao = new StorageDao();
	}

	@Test
	void TestListInsertion() throws JAXBException {
		ArrayList<Storage> storageListToAdd = new ArrayList<Storage>();
		ArrayList<Storage> localStorageList = storageDao.readComponents();

		Storage storage1 = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);
		Storage storage2 = new Storage("Samsung 850 evo 500GB (SSD)", 153, 10, 500, true);

		storageListToAdd.add(storage1);
		storageListToAdd.add(storage2);
		localStorageList.add(storage1);
		localStorageList.add(storage2);

		ArrayList<Storage> listWithInsertions = storageDao.addComponents(storageListToAdd);

		assertEquals(localStorageList, listWithInsertions, "Insertion storage list");

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
	
	@AfterEach
	void clearAll() throws JAXBException {
		
	}
}
