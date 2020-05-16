package tests.SequentialAssembler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;
import dataSource.PsuDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.PsuAssembly;


class PsuAssemblyTest {
	
	ComponentAssembly psuAssembly;
	PsuDao psuDao;
	FullConfigBuilder f1 = FullConfigBuilder.getIstance();

	
	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		psuAssembly = new PsuAssembly();
		psuDao = new PsuDao();
		psuDao.setEmptyComponents();
		f1.setCpu(null);
		f1.setGpu(null);
		f1.setMotherboard(null);
		f1.setCase(null);
		f1.setRam(null);
		f1.setStorage(null);
	}
	
	
	@Test
	void getCompatibleComponentsTest() throws JAXBException {
		Psu psu0 = new Psu("Prova0", 50, 600);
		Psu psu1 = new Psu("Prova1", 50, 650);
		Psu psu2 = new Psu("Prova2", 50, 800);

		
		ArrayList<Psu> psuList = new ArrayList<>();
		psuList.add(psu0);
		psuList.add(psu1);
		psuList.add(psu2);

		
		psuDao.addComponents(psuList);
		
		Cpu cpu = new Cpu("Cpu prova", 50, 100, "AM4", false);
		Gpu gpu = new Gpu("Gpu prova", 50, 100, 16);
		Motherboard motherboard = new Motherboard("Motherboard Prova", 55, 100, "LGA1150", "Z77", "DDR3", false, 2);
		Case case1 = new Case("Case prova", 55, 100, 3);
		Ram ram = new Ram("Ram prova", 55, 100, "DDR3", 8);
		Storage storage = new Storage("Storage prova", 55, 100, 500, true);
		

		f1.setCpu(cpu);
		f1.setGpu(gpu);
		f1.setMotherboard(motherboard);
		f1.setCase(case1);
		f1.setRam(ram);
		f1.setStorage(storage);
		
		ArrayList<Psu> compatibleComponents = psuAssembly.getCompatibleComponents(f1);
		
		assertFalse(compatibleComponents.contains(psu0), "Verifying the incompatibility of a ram with different ramType");
		assertFalse(compatibleComponents.contains(psu1), "Verifying the compatibility of a ram with different ramType");
		assertTrue(compatibleComponents.contains(psu2), "Verifying the compatibility of a ram with different ramType");
		
		f1.setCpu(null);
		f1.setGpu(null);
		f1.setMotherboard(null);
		f1.setCase(null);
		f1.setRam(null);
		f1.setStorage(null);

	}
	
	@Test
	void getComponentsByIndex() throws JAXBException {
		
		Cpu cpu = new Cpu("Cpu prova", 50, 100, "AM4", false);
		Gpu gpu = new Gpu("Gpu prova", 50, 100, 16);
		Motherboard motherboard = new Motherboard("Motherboard Prova", 55, 100, "LGA1150", "Z77", "DDR3", false, 2);
		Case case1 = new Case("Case prova", 55, 100, 3);
		Ram ram = new Ram("Ram prova", 55, 100, "DDR3", 8);
		Storage storage = new Storage("Storage prova", 55, 100, 500, true);
	
		f1.setCpu(cpu);
		f1.setGpu(gpu);
		f1.setMotherboard(motherboard);
		f1.setCase(case1);
		f1.setRam(ram);
		f1.setStorage(storage);
		
		Psu psu0 = new Psu("Prova0", 50, 600);
		Psu psu1 = new Psu("Prova1", 50, 650);
		Psu psu2 = new Psu("Prova2", 50, 700);

		ArrayList<Psu> psuList = new ArrayList<>();
		psuList.add(psu0);
		psuList.add(psu1);
		psuList.add(psu2);

		psuDao.addComponents(psuList);
		
		psuAssembly.InputBasedBehavior(psuAssembly, f1 , "0");
		assertEquals(f1.getMyPsu(), psu0, "Comparing the Case with right index");
		assertNotEquals(f1.getMyPsu(), psu1, "Choosing the Case with wrong index");

	}

	
	@AfterAll
	static void  clean() throws JAXBException 
	{
		PsuDao psuDao1 = new PsuDao();
		psuDao1.setDefaultComponents();
	}
	
}
