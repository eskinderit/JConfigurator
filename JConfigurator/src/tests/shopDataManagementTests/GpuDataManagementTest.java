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

import configuratorEngine.Gpu;
import dataSource.GpuDao;
import shopDataManagement.GpuDataManagement;


public class GpuDataManagementTest {
	static GpuDao gpuDao = new GpuDao();
	static ArrayList<Gpu> savedGpus = new ArrayList<Gpu>();
	ArrayList<Gpu> gpuList;
	GpuDataManagement gpuData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedGpus.addAll(gpuDao.readComponents());
		
		Gpu g = new Gpu("Gpu1", 50, 50, 50);
		ArrayList<Gpu> gpuToAdd = new ArrayList<Gpu>();
		gpuToAdd.add(g);
		gpuDao.addComponents(gpuToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		gpuList = gpuDao.readComponents();
		gpuData = new GpuDataManagement();
	}
	
	@Test
	public void deleteGpuTest() throws JAXBException {
		if(gpuDao.readComponents().size() > 0) {
			int index = (int)(Math.random() * gpuDao.readComponents().size());
			assertNotEquals(gpuData.deleteComp(index), gpuList, "Makes sure that components in Gpu.XML are not the same as before, after the deletion.");
			gpuList.remove(index);
			assertEquals(gpuDao.readComponents(), gpuList, "Makes sure that the componenent was removed from Gpu.XML file");
		}
	}
	
	@Test
	public void addGpuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		gpuData.addComp(parameter);
		assertNotEquals(gpuDao.readComponents(), gpuList, "Makes sure that components in Gpu.XML are not the same as before, after the addition.");
		Gpu gpuToAdd = new Gpu(gpuData.getName(), gpuData.getPrice(), gpuData.getPower(), gpuData.getMemory());
		gpuList.add(gpuToAdd);
		assertEquals(gpuDao.readComponents(), gpuList, "Makes sure that the componenent was added in Gpu.XML file");
		parameter.close();
	}
	
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		gpuDao.setEmptyComponents();
		gpuDao.addComponents(savedGpus);
	}
	
}
