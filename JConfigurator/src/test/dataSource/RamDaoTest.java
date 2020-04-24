package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Ram;
import dataSource.RamDao;

import org.junit.jupiter.api.*;

public class RamDaoTest {

	RamDao ramDao;
	ArrayList<Ram> ramList;
	Ram ram1;
	Ram ram2;
	
	
	@BeforeEach
	void init() {
		ramDao=new RamDao();
		ramList=new ArrayList<Ram>();
		ram1 = new Ram("ram1", 10, 10, "type", 10);
		ram2 = new Ram("ram2", 10, 10, "type", 10);
		ramList.add(ram1);
		ramList.add(ram2);
	}
	
	@Test
	void addRamList() throws JAXBException {
		ArrayList<Ram> localRamList = ramDao.readComponents();
		
		localRamList.addAll(ramList);
		ramDao.addComponents(ramList);
		
		assertEquals(localRamList, ramDao.readComponents(), "Add a Ram List");
	
	}
	
	@Test
	void testRemoveList() throws JAXBException {
		ArrayList<Ram> localRamList = ramDao.readComponents();
		localRamList.removeAll(ramList);
		ramDao.deleteComponents(ramList);
		
		assertEquals(localRamList, ramDao.readComponents(), "Remove a ram list");
		
	}
	
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Ram> localramList = new ArrayList<Ram>();
		ramDao.setEmptyComponents();
		
		assertEquals(localramList, ramDao.readComponents(), "Set an empty Ram List");
		
	}
	
	@Test
	void testAddOnEmptyFile() throws JAXBException {
		ramDao.setEmptyComponents();
		ramDao.addComponents(ramList);
		
		assertEquals(ramDao.readComponents(), ramList, "Add elements on an empty file");
		
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		ramDao.setDefaultComponents();
	}
}
