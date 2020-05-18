package tests.daoTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Cpu;

import org.junit.jupiter.api.*;
import dataSource.CpuDao;

public class CpuDaoTest {
	CpuDao cpuDao;
	ArrayList<Cpu> cpuList;
	Cpu cpu1;
	Cpu cpu2;
	
	@BeforeEach
	void init() {
		cpuDao=new CpuDao();
		cpuList=new ArrayList<Cpu>();
		cpu1 = new Cpu("Cpu1", 10, 10, "socket", true);
		cpu2 = new Cpu("Cpu2", 10, 10, "socket", true);
		cpuList.add(cpu1);
		cpuList.add(cpu2);
	}
	
	@Test
	void testAddCpuList() throws JAXBException {
		ArrayList<Cpu> localCpuList=cpuDao.readComponents();
		
		cpuDao.addComponents(cpuList);
		localCpuList.addAll(cpuList);
		
		assertEquals(localCpuList, cpuDao.readComponents(), "Add a cpu list");
		
	}
	
	@Test
	void testAddSameElements() throws JAXBException {
		ArrayList<Cpu> localCpuList=cpuDao.readComponents();
		
		localCpuList.addAll(cpuList);
		cpuDao.addComponents(cpuList);
		cpuDao.addComponents(cpuList);
		assertEquals(localCpuList, cpuDao.readComponents(), "Can only add the same cpuList once");
		cpuDao.addComponents(cpuList);
		localCpuList.addAll(cpuList);
		assertNotEquals(localCpuList, cpuDao.readComponents(), "Can only add the same cpuList once");
	}
	
	@Test
	void testRemoveCpuList() throws JAXBException {
		ArrayList<Cpu> localCpuList = cpuDao.readComponents();
		
		localCpuList.removeAll(cpuList);
		cpuDao.deleteComponents(cpuList);
		
		assertEquals(localCpuList, cpuDao.readComponents(), "Remove a cpu list");
		
	}
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Cpu> localCpuList = new ArrayList<Cpu>();
		
		cpuDao.setEmptyComponents();
		assertEquals(localCpuList, cpuDao.readComponents(), "Set an empty Cpu List");
	}
	
	@Test
	void testAddOnEmptyFile() throws JAXBException {
		cpuDao.setEmptyComponents();
		cpuDao.addComponents(cpuList);
		
		assertEquals(cpuDao.readComponents(), cpuList, "Add elements on an empty file");
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		cpuDao.setDefaultComponents();
	}
}