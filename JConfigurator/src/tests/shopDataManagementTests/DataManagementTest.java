package tests.shopDataManagementTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Case;
import configuratorEngine.Cpu;
import configuratorEngine.Gpu;
import configuratorEngine.Motherboard;
import configuratorEngine.Psu;
import configuratorEngine.Ram;
import configuratorEngine.Storage;
import dataSource.CaseDao;
import dataSource.CpuDao;
import dataSource.GpuDao;
import dataSource.MotherboardDao;
import dataSource.PsuDao;
import dataSource.RamDao;
import dataSource.StorageDao;
import shopDataManagement.DataManagement;

public class DataManagementTest {
	DataManagement shopData;
	static CaseDao caseDao = new CaseDao();
	static CpuDao cpuDao = new CpuDao();
	static GpuDao gpuDao = new GpuDao();
	static MotherboardDao motherboardDao = new MotherboardDao();
	static PsuDao psuDao = new PsuDao();
	static RamDao ramDao = new RamDao();
	static StorageDao storageDao = new StorageDao();
	
	static ArrayList<Case> savedCases = new ArrayList<Case>();
	static ArrayList<Cpu> savedCpus = new ArrayList<Cpu>();
	static ArrayList<Gpu> savedGpus = new ArrayList<Gpu>();
	static ArrayList<Motherboard> savedMotherboards = new ArrayList<Motherboard>();
	static ArrayList<Psu> savedPsus = new ArrayList<Psu>();
	static ArrayList<Ram> savedRams = new ArrayList<Ram>();
	static ArrayList<Storage> savedStorages = new ArrayList<Storage>();
	
	ArrayList<Case> caseList;
	ArrayList<Cpu> cpuList;
	ArrayList<Gpu> gpuList;
	ArrayList<Motherboard> motherboardList;
	ArrayList<Ram> ramList;
	ArrayList<Storage> storageList;
	ArrayList<Psu> psuList;
	
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedCases.addAll(caseDao.readComponents());
		savedCpus.addAll(cpuDao.readComponents());
		savedGpus.addAll(gpuDao.readComponents());
		savedMotherboards.addAll(motherboardDao.readComponents());
		savedPsus.addAll(psuDao.readComponents());
		savedRams.addAll(ramDao.readComponents());
		savedStorages.addAll(storageDao.readComponents());
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		shopData = new DataManagement();
		caseList = caseDao.readComponents();
		cpuList = cpuDao.readComponents();
		gpuList = gpuDao.readComponents();
		motherboardList = motherboardDao.readComponents();
		ramList = ramDao.readComponents();
		psuList = psuDao.readComponents();
		storageList = storageDao.readComponents();
	}
	
	@Test
	public void deletecTest() throws JAXBException {
		shopData.deletec(0, "a");
		assertNotEquals(cpuList, cpuDao.readComponents(), "Makes sure that components in Cpu.XML are not the same as before, after the deletion.");
		cpuList.remove(0);
		assertEquals(cpuList, cpuDao.readComponents(), "Makes sure that the componenent was removed from Cpu.XML file");
		
		shopData.deletec(0, "b");
		assertNotEquals(gpuList, gpuDao.readComponents(), "Makes sure that components in Gpu.XML are not the same as before, after the deletion.");
		gpuList.remove(0);
		assertEquals(gpuList, gpuDao.readComponents(), "Makes sure that the componenent was removed from Gpu.XML file");
		
		shopData.deletec(0, "c");
		assertNotEquals(motherboardList, motherboardDao.readComponents(), "Makes sure that components in Motherbaord.XML are not the same as before, after the deletion.");
		motherboardList.remove(0);
		assertEquals(motherboardList, motherboardDao.readComponents(), "Makes sure that the componenent was removed from Motherboard.XML file");
		
		shopData.deletec(0, "d");
		assertNotEquals(caseList, caseDao.readComponents(), "Makes sure that components in Case.XML are not the same as before, after the deletion.");
		caseList.remove(0);
		assertEquals(caseList, caseDao.readComponents(), "Makes sure that the componenent was removed from Case.XML file");
		
		shopData.deletec(0, "e");
		assertNotEquals(ramList, ramDao.readComponents(), "Makes sure that components in Ram.XML are not the same as before, after the deletion.");
		ramList.remove(0);
		assertEquals(ramList, ramDao.readComponents(), "Makes sure that the componenent was removed from Ram.XML file");
		
		shopData.deletec(0, "f");
		assertNotEquals(storageList, storageDao.readComponents(), "Makes sure that components in Storage.XML are not the same as before, after the deletion.");
		storageList.remove(0);
		assertEquals(storageList, storageDao.readComponents(), "Makes sure that the componenent was removed from Storage.XML file");
		
		shopData.deletec(0, "g");
		assertNotEquals(psuList, psuDao.readComponents(), "Makes sure that components in Psu.XML are not the same as before, after the deletion.");
		psuList.remove(0);
		assertEquals(psuList, psuDao.readComponents(), "Makes sure that the componenent was removed from Psu.XML file");
	}
	
	
	@Test
	public void resetcTest() throws JAXBException {
		shopData.resetc("a");
		assertEquals(cpuDao.readComponents(), cpuDao.setDefaultComponents(), "Makes sure that Gpu.Xml file contains defauld data from CpuDefault.XML file");
		shopData.resetc("b");
		assertEquals(gpuDao.readComponents(), gpuDao.setDefaultComponents(), "Makes sure that Gpu.Xml file contains defauld data from GpuDefault.XML file");
		shopData.resetc("c");
		assertEquals(motherboardDao.readComponents(), motherboardDao.setDefaultComponents(), "Makes sure that Motherboard.Xml file contains defauld data from GpuDefault.XML file");
		shopData.resetc("d");
		assertEquals(caseDao.readComponents(), caseDao.setDefaultComponents(), "Makes sure that Case.Xml file contains defauld data from GpuDefault.XML file");
		shopData.resetc("e");
		assertEquals(ramDao.readComponents(), ramDao.setDefaultComponents(), "Makes sure that Ram.Xml file contains defauld data from GpuDefault.XML file");
		shopData.resetc("f");
		assertEquals(storageDao.readComponents(), storageDao.setDefaultComponents(), "Makes sure that Storage.Xml file contains defauld data from GpuDefault.XML file");
		shopData.resetc("g");
		assertEquals(psuDao.readComponents(), psuDao.setDefaultComponents(), "Makes sure that Psu.Xml file contains defauld data from GpuDefault.XML file");
		
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		cpuDao.setEmptyComponents();
		cpuDao.addComponents(savedCpus);
		gpuDao.setEmptyComponents();
		gpuDao.addComponents(savedGpus);
		motherboardDao.setEmptyComponents();
		motherboardDao.addComponents(savedMotherboards);
		caseDao.setEmptyComponents();
		caseDao.addComponents(savedCases);
		ramDao.setEmptyComponents();
		ramDao.addComponents(savedRams);
		storageDao.setEmptyComponents();
		storageDao.addComponents(savedStorages);
		psuDao.setEmptyComponents();
		psuDao.addComponents(savedPsus);
	}
	
}
