package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Ram;
import dataSource.RamDao;

import org.junit.jupiter.api.*;

public class RamDaoTest {

	RamDao ramDao;
	
	@BeforeEach
	void init() {
		ramDao=new RamDao();
	}
	
	@Test
	void testListInsertion() throws JAXBException {
		ArrayList<Ram> ramListToAdd=new ArrayList<Ram>();
		ArrayList<Ram> localRamList = ramDao.readComponents();
		
		Ram ram1=new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2=new Ram("Corsair Dominator Platinum DDR4 (4x8)", 318, 10, "DDR4", 32);
		
		ramListToAdd.add(ram1);
		ramListToAdd.add(ram2);
		localRamList.add(ram1);
		localRamList.add(ram2);
		
		ArrayList<Ram> ramListWithInsertion=ramDao.addComponents(ramListToAdd);
		
		assertEquals(localRamList, ramListWithInsertion, "Insertion ram list");
	}
	
	@Test
	void testRemoveList() throws JAXBException {
		ArrayList<Ram> ramListToDelete = new ArrayList<Ram>();
		ArrayList<Ram> localRamList = ramDao.readComponents();
		
		Ram ram1 = new Ram("Corsair Dominator Platinum DDR4 (4x8)", 318, 10, "DDR4", 32);
		Ram ram2 = new Ram("Corsair Vengeance Pro DDR3 (2x8)", 125, 10, "DDR3", 16);
		
		ramListToDelete.add(ram1);
		ramListToDelete.add(ram2);
		localRamList.removeAll(ramListToDelete);
		
		ArrayList<Ram> ramListWithRemoves = ramDao.deleteComponents(ramListToDelete);
		
		assertEquals(localRamList, ramListWithRemoves, "Remove ram list");
	}
}