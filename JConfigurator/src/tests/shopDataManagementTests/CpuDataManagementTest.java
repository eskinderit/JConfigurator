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

import configuratorEngine.Cpu;
import dataSource.CpuDao;
import shopDataManagement.CpuDataManagement;


public class CpuDataManagementTest {
	static CpuDao cpuDao = new CpuDao();
	static ArrayList<Cpu> savedCpus = new ArrayList<Cpu>();
	ArrayList<Cpu> cpuList;
	CpuDataManagement cpuData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedCpus.addAll(cpuDao.readComponents());
		
		Cpu c = new Cpu("Cpu1", 50, 50, "Socket1", true);
		ArrayList<Cpu> cpuToAdd = new ArrayList<Cpu>();
		cpuToAdd.add(c);
		cpuDao.addComponents(cpuToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		cpuList = cpuDao.readComponents();
		cpuData = new CpuDataManagement();
	}
	
	@Test
	public void deleteCpuTest() throws JAXBException {
		if(cpuDao.readComponents().size() > 0) {
			int index = (int)(Math.random() * cpuDao.readComponents().size());
			assertNotEquals(cpuData.deleteComp(index), cpuList, "Makes sure that components in Cpu.XML are not the same as before, after the deletion.");
			cpuList.remove(index);
			assertEquals(cpuDao.readComponents(), cpuList, "Makes sure that the componenent was removed from Cpu.XML file");
		}
	}
	
	@Test
	public void addCpuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		cpuData.addComp(parameter);
		assertNotEquals(cpuDao.readComponents(), cpuList, "Makes sure that components in Cpu.XML are not the same as before, after the addition.");
		Cpu cpuToAdd = new Cpu(cpuData.getName(), cpuData.getPrice(), cpuData.getPower(), cpuData.getSocket(), cpuData.isOc());
		cpuList.add(cpuToAdd);
		assertEquals(cpuDao.readComponents(), cpuList, "Makes sure that the componenent was added in Cpu.XML file");
		parameter.close();
	}
	
	@Test 
	public void resetCpusTest() throws JAXBException {
		assertEquals(cpuData.resetComp(), cpuDao.setDefaultComponents(), "Makes sure that Cpu.Xml file contains defauld data from CpuDefault.XML file");
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		cpuDao.setEmptyComponents();
		cpuDao.addComponents(savedCpus);
	}
	
}
