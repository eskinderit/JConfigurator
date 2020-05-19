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


import ConfiguratorEngine.Cpu;
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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		cpuList = cpuDao.readComponents();
		cpuData = new CpuDataManagement();
	}
	
	@Test
	public void deleteCpuTest() throws JAXBException {
		int index = (int)Math.random() * (cpuDao.readComponents().size());
		assertNotEquals(cpuData.deleteComp(index), cpuList, " ");
		cpuList.remove(index);
		assertEquals(cpuDao.readComponents(), cpuList, " ");
	}
	
	@Test
	public void addCpuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		cpuData.addComp(parameter);
		assertNotEquals(cpuDao.readComponents(), cpuList, " ");
		Cpu cpuToAdd = new Cpu(cpuData.name, cpuData.price, cpuData.power, cpuData.socket, cpuData.oc);
		cpuList.add(cpuToAdd);
		assertEquals(cpuDao.readComponents(), cpuList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetCpusTest() throws JAXBException {
		assertEquals(cpuData.resetComp(), cpuDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		cpuDao.setEmptyComponents();
		cpuDao.addComponents(savedCpus);
	}
	
}
