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

import configuratorEngine.Ram;
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
		
		Ram r = new Ram("Ram1", 50, 50, "Ramtype", 50);
		ArrayList<Ram> ramToAdd = new ArrayList<Ram>();
		ramToAdd.add(r);
		ramDao.addComponents(ramToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		ramList = ramDao.readComponents();
		ramData = new RamDataManagement();
	}
	
	@Test
	public void deleteRamTest() throws JAXBException {
		if(ramDao.readComponents().size() > 0) {
			int index = (int)(Math.random() * ramDao.readComponents().size());
			assertNotEquals(ramData.deleteComp(index), ramList, "Makes sure that components in Ram.XML are not the same as before, after the deletion.");
			ramList.remove(index);
			assertEquals(ramDao.readComponents(), ramList, "Makes sure that the componenent was removed from Ram.XML file");
		}
	}
	
	@Test
	public void addRamTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		ramData.addComp(parameter);
		assertNotEquals(ramDao.readComponents(), ramList, "Makes sure that components in Ram.XML are not the same as before, after the addition.");
		Ram ramToAdd = new Ram(ramData.getName(), ramData.getPrice(), ramData.getPower(), ramData.getRamType(), ramData.getMemory());
		ramList.add(ramToAdd);
		assertEquals(ramDao.readComponents(), ramList, "Makes sure that the componenent was added in Ram.XML file");
		parameter.close();
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		ramDao.setEmptyComponents();
		ramDao.addComponents(savedRams);
	}
	
}
