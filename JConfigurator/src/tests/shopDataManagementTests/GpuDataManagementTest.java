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


import ConfiguratorEngine.Gpu;
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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		gpuList = gpuDao.readComponents();
		gpuData = new GpuDataManagement();
	}
	
	@Test
	public void deleteGpuTest() throws JAXBException {
		int index = (int)Math.random() * (gpuDao.readComponents().size());
		assertNotEquals(gpuData.deleteComp(index), gpuList, " ");
		gpuList.remove(index);
		assertEquals(gpuDao.readComponents(), gpuList, " ");
	}
	
	@Test
	public void addGpuTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		gpuData.addComp(parameter);
		assertNotEquals(gpuDao.readComponents(), gpuList, " ");
		Gpu gpuToAdd = new Gpu(gpuData.name, gpuData.price, gpuData.power, gpuData.memory);
		gpuList.add(gpuToAdd);
		assertEquals(gpuDao.readComponents(), gpuList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetGpusTest() throws JAXBException {
		assertEquals(gpuData.resetComp(), gpuDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		gpuDao.setEmptyComponents();
		gpuDao.addComponents(savedGpus);
	}
	
}
