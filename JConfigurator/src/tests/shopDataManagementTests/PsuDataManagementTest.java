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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		psuList = psuDao.readComponents();
		psuData = new PsuDataManagement();
	}
	
	@Test
	public void deletePsuTest() throws JAXBException {
		int index = (int)Math.random() * (psuDao.readComponents().size());
		assertNotEquals(psuData.deleteComp(index), psuList, " ");
		psuList.remove(index);
		assertEquals(psuDao.readComponents(), psuList, " ");
	}
	
	@Test
	public void addPsuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		psuData.addComp(parameter);
		assertNotEquals(psuDao.readComponents(), psuList, " ");
		Psu psuToAdd = new Psu(psuData.name, psuData.price, psuData.power);
		psuList.add(psuToAdd);
		assertEquals(psuDao.readComponents(), psuList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetPsusTest() throws JAXBException {
		assertEquals(psuData.resetComp(), psuDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		psuDao.setEmptyComponents();
		psuDao.addComponents(savedPsus);
	}
	
}
