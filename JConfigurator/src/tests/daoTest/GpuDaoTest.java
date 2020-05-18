package tests.daoTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Gpu;

import org.junit.jupiter.api.*;
import dataSource.GpuDao;

public class GpuDaoTest {
	GpuDao gpuDao;
	ArrayList<Gpu> gpuList;
	Gpu gpu1;
	Gpu gpu2;
	
	@BeforeEach
	void init() {
		gpuDao=new GpuDao();
		gpuList=new ArrayList<Gpu>();
		gpu1 = new Gpu("gpu1", 10, 10, 10);
		gpu2 = new Gpu("gpu2", 10, 10, 10);
		gpuList.add(gpu1);
		gpuList.add(gpu2);
	}
	
	@Test
	void testAddgpuList() throws JAXBException {
		ArrayList<Gpu> localgpuList=gpuDao.readComponents();
		
		gpuDao.addComponents(gpuList);
		localgpuList.addAll(gpuList);
		
		assertEquals(localgpuList, gpuDao.readComponents(), "Add a gpu list");
	}
	
	@Test
	void testAddSameElements() throws JAXBException {
		ArrayList<Gpu> localgpuList=gpuDao.readComponents();
		
		localgpuList.addAll(gpuList);
		gpuDao.addComponents(gpuList);
		gpuDao.addComponents(gpuList);
		assertEquals(localgpuList, gpuDao.readComponents(), "Can only add the same gpuList once");
		gpuDao.addComponents(gpuList);
		localgpuList.addAll(gpuList);
		assertNotEquals(localgpuList, gpuDao.readComponents(), "Can only add the same gpuList once");
	}
	
	@Test
	void testRemovegpuList() throws JAXBException {
		ArrayList<Gpu> localgpuList = gpuDao.readComponents();
		
		localgpuList.removeAll(gpuList);
		gpuDao.deleteComponents(gpuList);
		
		assertEquals(localgpuList, gpuDao.readComponents(), "Remove a gpu list");
		
	}
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Gpu> localgpuList = new ArrayList<Gpu>();
		
		gpuDao.setEmptyComponents();
		assertEquals(localgpuList, gpuDao.readComponents(), "Set an empty gpu List");
	}
	
	@Test
	void testAddOnEmptyFile() throws JAXBException {
		gpuDao.setEmptyComponents();
		gpuDao.addComponents(gpuList);
		
		assertEquals(gpuDao.readComponents(), gpuList, "Add elements on an empty file");
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		gpuDao.setDefaultComponents();
	}
}