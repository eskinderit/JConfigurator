package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Motherboard;

import org.junit.jupiter.api.*;
import dataSource.MotherboardDao;

public class MotherboardDaoTest {
	MotherboardDao motherboardDao;
	ArrayList<Motherboard> motherboardList;
	Motherboard motherboard1;
	Motherboard motherboard2;
	
	@BeforeEach
	void init() {
		motherboardDao=new MotherboardDao();
		motherboardList=new ArrayList<Motherboard>();
		motherboard1 = new Motherboard("motherboard1", 10, 10, "socket", "chipset", "ramType", true, 10);
		motherboard2 = new Motherboard("motherboard2", 10, 10, "socket", "chipset", "ramType", true, 10);
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);
	}
	
	@Test
	void testAddmotherboardList() throws JAXBException {
		ArrayList<Motherboard> localmotherboardList=motherboardDao.readComponents();
		
		motherboardDao.addComponents(motherboardList);
		localmotherboardList.addAll(motherboardList);
		
		assertEquals(localmotherboardList, motherboardDao.readComponents(), "Add a motherboard list");
	}
	
	@Test
	void testAddSameElements() throws JAXBException {
		ArrayList<Motherboard> localmotherboardList=motherboardDao.readComponents();
		
		localmotherboardList.addAll(motherboardList);
		motherboardDao.addComponents(motherboardList);
		motherboardDao.addComponents(motherboardList);
		assertEquals(localmotherboardList, motherboardDao.readComponents(), "Can only add the same motherboardList once");
		motherboardDao.addComponents(motherboardList);
		localmotherboardList.addAll(motherboardList);
		assertNotEquals(localmotherboardList, motherboardDao.readComponents(), "Can only add the same motherboardList once");
	}
	
	@Test
	void testRemovemotherboardList() throws JAXBException {
		ArrayList<Motherboard> localmotherboardList = motherboardDao.readComponents();
		
		localmotherboardList.removeAll(motherboardList);
		motherboardDao.deleteComponents(motherboardList);
		
		assertEquals(localmotherboardList, motherboardDao.readComponents(), "Remove a motherboard list");
		
	}
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Motherboard> localmotherboardList = new ArrayList<Motherboard>();
		
		motherboardDao.setEmptyComponents();
		assertEquals(localmotherboardList, motherboardDao.readComponents(), "Set an empty motherboard List");
	}
	
	@Test
	void testAddOnEmptyFile() throws JAXBException {
		motherboardDao.setEmptyComponents();
		motherboardDao.addComponents(motherboardList);
		
		assertEquals(motherboardDao.readComponents(), motherboardList, "Add elements on an empty file");
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		motherboardDao.setDefaultComponents();
	}
}