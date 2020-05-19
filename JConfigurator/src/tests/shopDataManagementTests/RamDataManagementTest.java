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


import ConfiguratorEngine.Ram;
import dataSource.RamDao;
import shopDataManagement.RamDataManagement;


public class RamDataManagementTest {
	static RamDao ramDao = new RamDao();
	static ArrayList<Ram> savedRams = new ArrayList<Ram>();
	ArrayList<Ram> ramList;
	RamDataManagement ramData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedRams.addAll(ramDao.readComponents());
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		ramList = ramDao.readComponents();
		ramData = new RamDataManagement();
	}
	
	@Test
	public void deleteRamTest() throws JAXBException {
		int index = (int)Math.random() * (ramDao.readComponents().size());
		assertNotEquals(ramData.deleteComp(index), ramList, " ");
		ramList.remove(index);
		assertEquals(ramDao.readComponents(), ramList, " ");
	}
	
	@Test
	public void addRamTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		ramData.addComp(parameter);
		assertNotEquals(ramDao.readComponents(), ramList, " ");
		Ram ramToAdd = new Ram(ramData.name, ramData.price, ramData.power, ramData.ramType, ramData.memory);
		ramList.add(ramToAdd);
		assertEquals(ramDao.readComponents(), ramList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetRamsTest() throws JAXBException {
		assertEquals(ramData.resetComp(), ramDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		ramDao.setEmptyComponents();
		ramDao.addComponents(savedRams);
	}
	
}
