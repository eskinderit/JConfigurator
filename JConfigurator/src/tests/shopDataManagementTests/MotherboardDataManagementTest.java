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

import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;
import shopDataManagement.MotherboardDataManagement;


public class MotherboardDataManagementTest {
	static MotherboardDao motherboardDao = new MotherboardDao();
	static ArrayList<Motherboard> savedMotherboards = new ArrayList<Motherboard>();
	ArrayList<Motherboard> motherboardList;
	MotherboardDataManagement motherboardData;
	
	
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedMotherboards.addAll(motherboardDao.readComponents());
		
		Motherboard m = new Motherboard("Motherboard1", 50, 50, "Socket1", "RamType", "ChipSet", true, 50);
		ArrayList<Motherboard> motherboardToAdd = new ArrayList<Motherboard>();
		motherboardToAdd.add(m);
		motherboardDao.addComponents(motherboardToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		motherboardList = motherboardDao.readComponents();
		motherboardData = new MotherboardDataManagement();
	}
	
	@Test
	public void deleteMotherboardTest() throws JAXBException {
		if(motherboardDao.readComponents().size() > 0) {
			int index = (int)(Math.random() * motherboardDao.readComponents().size());
			assertNotEquals(motherboardData.deleteComp(index), motherboardList, "Makes sure that components in Motherboard.XML are not the same as before, after the deletion.");
			motherboardList.remove(index);
			assertEquals(motherboardDao.readComponents(), motherboardList, "Makes sure that the componenent was removed from Motherboard.XML file");
		}
	}
	
	@Test
	public void addMotherboardTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		motherboardData.addComp(parameter);
		assertNotEquals(motherboardDao.readComponents(), motherboardList, "Makes sure that components in Motherboard.XML are not the same as before, after the addition.");
		Motherboard motherboardToAdd = new Motherboard(motherboardData.getName(), motherboardData.getPrice(), motherboardData.getPower(), motherboardData.getSocket(), motherboardData.getChipset(), motherboardData.getRamType(), motherboardData.isOc(), motherboardData.getSize());
		motherboardList.add(motherboardToAdd);
		assertEquals(motherboardDao.readComponents(), motherboardList, "Makes sure that the componenent was added in Motherboard.XML file");
		parameter.close();
	}
	
	@Test 
	public void resetMotherboardsTest() throws JAXBException {
		assertEquals(motherboardData.resetComp(), motherboardDao.setDefaultComponents(), "Makes sure that Motherboard.Xml file contains defauld data from MotherboardDefault.XML file");
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		motherboardDao.setEmptyComponents();
		motherboardDao.addComponents(savedMotherboards);
	}
	
}
