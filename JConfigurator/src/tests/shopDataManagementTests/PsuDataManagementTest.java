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

import ConfiguratorEngine.Psu;
import dataSource.PsuDao;
import shopDataManagement.PsuDataManagement;


public class PsuDataManagementTest {
	static PsuDao psuDao = new PsuDao();
	static ArrayList<Psu> savedPsus = new ArrayList<Psu>();
	ArrayList<Psu> psuList;
	PsuDataManagement psuData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedPsus.addAll(psuDao.readComponents());
		
		Psu p = new Psu("Psu1", 50, 50);
		ArrayList<Psu> psuToAdd = new ArrayList<Psu>();
		psuToAdd.add(p);
		psuDao.addComponents(psuToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		psuList = psuDao.readComponents();
		psuData = new PsuDataManagement();
	}
	
	@Test
	public void deletePsuTest() throws JAXBException {
		if(psuDao.readComponents().size() > 0) {
			int index = (int)(Math.random() * psuDao.readComponents().size());
			assertNotEquals(psuData.deleteComp(index), psuList, "Makes sure that components in Psu.XML are not the same as before, after the deletion.");
			psuList.remove(index);
			assertEquals(psuDao.readComponents(), psuList, "Makes sure that the componenent was removed from Psu.XML file");
		}
	}
	
	@Test
	public void addPsuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		psuData.addComp(parameter);
		assertNotEquals(psuDao.readComponents(), psuList, "Makes sure that components in Psu.XML are not the same as before, after the addition.");
		Psu psuToAdd = new Psu(psuData.getName(), psuData.getPrice(), psuData.getPower());
		psuList.add(psuToAdd);
		assertEquals(psuDao.readComponents(), psuList, "Makes sure that the componenent was added in Psu.XML file");
		parameter.close();
	}
	
	@Test 
	public void resetPsusTest() throws JAXBException {
		assertEquals(psuData.resetComp(), psuDao.setDefaultComponents(), "Makes sure that Psu.Xml file contains defauld data from PsuDefault.XML file");
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		psuDao.setEmptyComponents();
		psuDao.addComponents(savedPsus);
	}
	
}
