package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Cpu;

import org.junit.jupiter.api.*;
import dataSource.CpuDao;

public class CpuDaoTest {
	CpuDao cpuDao;
	
	@BeforeEach
	void init() {
		cpuDao=new CpuDao();
	}
	
	@Test
	void testListInsertion() throws JAXBException {
		ArrayList<Cpu> cpuListToAdd=new ArrayList<Cpu>();
		ArrayList<Cpu> localCpuList=cpuDao.readComponents();
		
		Cpu cpu1 = new Cpu("AMD Ryzen 5 1400 (AM4)", 176, 10, "AM4", true);
		Cpu cpu2 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		cpuListToAdd.add(cpu1);
		cpuListToAdd.add(cpu2);
		localCpuList.add(cpu1);
		localCpuList.add(cpu2);
		
		ArrayList<Cpu> cpuListWithInsertions = cpuDao.addComponents(cpuListToAdd);
		
		assertEquals(cpuListWithInsertions, localCpuList, "Cpu List Insertion");
	}
	
	@Test
	void testRemoveList() throws JAXBException {
		ArrayList<Cpu> cpuListToRemove = new ArrayList<Cpu>();
		ArrayList<Cpu> localCpuList = cpuDao.readComponents();
		
		Cpu cpu1 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("AMD Ryzen 7 1800x (AM4)", 425, 10, "AM4", true);
		
		cpuListToRemove.add(cpu1);
		cpuListToRemove.add(cpu2);
		
		localCpuList.removeAll(cpuListToRemove);
		
		ArrayList<Cpu> cpuListWithRemoves = cpuDao.deleteComponents(cpuListToRemove);
		
		assertEquals(localCpuList, cpuListWithRemoves, "Cpu List Remove");
	}
	
	
	
	@AfterEach
	void clearAll() throws JAXBException {
		cpuDao.setDefaultComponents();
	}
}