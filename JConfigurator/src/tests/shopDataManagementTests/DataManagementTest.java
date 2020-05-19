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

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;
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
		assertNotEquals(cpuList, cpuDao.readComponents(), " ");
		cpuList.remove(0);
		assertEquals(cpuList, cpuDao.readComponents(), " ");
		
		shopData.deletec(0, "b");
		assertNotEquals(gpuList, gpuDao.readComponents(), " ");
		gpuList.remove(0);
		assertEquals(gpuList, gpuDao.readComponents(), " ");
		
		shopData.deletec(0, "c");
		assertNotEquals(motherboardList, motherboardDao.readComponents(), " ");
		motherboardList.remove(0);
		assertEquals(motherboardList, motherboardDao.readComponents(), " ");
		
		shopData.deletec(0, "d");
		assertNotEquals(caseList, caseDao.readComponents(), " ");
		caseList.remove(0);
		assertEquals(caseList, caseDao.readComponents(), " ");
		
		shopData.deletec(0, "e");
		assertNotEquals(ramList, ramDao.readComponents(), " ");
		ramList.remove(0);
		assertEquals(ramList, ramDao.readComponents(), " ");
		
		shopData.deletec(0, "f");
		assertNotEquals(storageList, storageDao.readComponents(), " ");
		storageList.remove(0);
		assertEquals(storageList, storageDao.readComponents(), " ");
		
		shopData.deletec(0, "g");
		assertNotEquals(psuList, psuDao.readComponents(), " ");
		psuList.remove(0);
		assertEquals(psuList, psuDao.readComponents(), " ");
	}
	
	@Test
	public void addcTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		shopData.addc("d", parameter);
		Case caseToAdd = caseDao.getComponent(caseDao.readComponents().size()-1);
		assertNotEquals(caseList, caseDao.readComponents(), " ");
		caseList.add(caseToAdd);
		assertEquals(caseList, caseDao.readComponents(), " ");
	}
	
	@Test
	public void resetcTest() throws JAXBException {
		shopData.resetc("a");
		assertEquals(cpuDao.readComponents(), cpuDao.setDefaultComponents(), " ");
		shopData.resetc("b");
		assertEquals(gpuDao.readComponents(), gpuDao.setDefaultComponents(), " ");
		shopData.resetc("c");
		assertEquals(motherboardDao.readComponents(), motherboardDao.setDefaultComponents(), " ");
		shopData.resetc("d");
		assertEquals(caseDao.readComponents(), caseDao.setDefaultComponents(), " ");
		shopData.resetc("e");
		assertEquals(ramDao.readComponents(), ramDao.setDefaultComponents(), " ");
		shopData.resetc("f");
		assertEquals(storageDao.readComponents(), storageDao.setDefaultComponents(), " ");
		shopData.resetc("g");
		assertEquals(psuDao.readComponents(), psuDao.setDefaultComponents(), " ");
		
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
