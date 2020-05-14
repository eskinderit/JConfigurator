package testNonSequentialAssembler;

import nonSequentialAssembler.StorageSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;


import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Storage;
import dataSource.StorageDao;


public class StorageSelectionTest {
	FullConfigBuilder f;
	StorageSelection storages;
	
	@BeforeEach
	public void init() throws JAXBException {
		f = new FullConfigBuilder();
		storages = new StorageSelection();
	}
	
	@Test
	public void CompatibleStorages() throws JAXBException {
		StorageDao storageDao = new StorageDao();
		ArrayList<Storage> storageList1 = new ArrayList<Storage>();
		ArrayList<Storage> storageList2 = new ArrayList<Storage>();
		
		storageList1 = storageDao.readComponents();
		storageList2 = storages.getCompatibleComponents(f);
		
		assertEquals(storageList1, storageList2, "Test compatible Storages");
	}
}
