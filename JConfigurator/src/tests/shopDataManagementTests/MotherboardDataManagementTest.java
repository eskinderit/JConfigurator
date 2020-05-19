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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		motherboardList = motherboardDao.readComponents();
		motherboardData = new MotherboardDataManagement();
	}
	
	@Test
	public void deleteMotherboardTest() throws JAXBException {
		int index = (int)Math.random() * (motherboardDao.readComponents().size());
		assertNotEquals(motherboardData.deleteComp(index), motherboardList, " ");
		motherboardList.remove(index);
		assertEquals(motherboardDao.readComponents(), motherboardList, " ");
	}
	
	@Test
	public void addMotherboardTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		motherboardData.addComp(parameter);
		assertNotEquals(motherboardDao.readComponents(), motherboardList, " ");
		Motherboard motherboardToAdd = new Motherboard(motherboardData.name, motherboardData.price, motherboardData.power, motherboardData.socket, motherboardData.chipset, motherboardData.ramType, motherboardData.oc, motherboardData.size);
		motherboardList.add(motherboardToAdd);
		assertEquals(motherboardDao.readComponents(), motherboardList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetMotherboardsTest() throws JAXBException {
		assertEquals(motherboardData.resetComp(), motherboardDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		motherboardDao.setEmptyComponents();
		motherboardDao.addComponents(savedMotherboards);
	}
	
}
