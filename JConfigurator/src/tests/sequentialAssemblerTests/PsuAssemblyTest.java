package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Case;
import configuratorEngine.Cpu;
import configuratorEngine.FullConfig;
import configuratorEngine.Gpu;
import configuratorEngine.Motherboard;
import configuratorEngine.Psu;
import configuratorEngine.Ram;
import configuratorEngine.Storage;
import dataSource.PsuDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.PsuAssembly;

class PsuAssemblyTest {

	ComponentAssembly<Psu> psuAssembly;
	PsuDao psuDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		psuAssembly = new PsuAssembly();
		psuDao = new PsuDao();
		psuDao.setEmptyComponents();
		f1 = new FullConfig();
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
		f1.setCase0(case1);
		f1.setRam(ram);
		f1.setStorage(storage);

		ArrayList<Psu> compatibleComponents = psuAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(psu0),
				"Verifying the incompatibility of a ram with different ramType");
		assertFalse(compatibleComponents.contains(psu1), "Verifying the compatibility of a ram with different ramType");
		assertTrue(compatibleComponents.contains(psu2), "Verifying the compatibility of a ram with different ramType");

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
		f1.setCase0(case1);
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

		psuAssembly.InputBasedBehavior(f1, "0");
		assertEquals(f1.getPsu(), psu0, "Comparing the Case with right index");
		assertNotEquals(f1.getPsu(), psu1, "Choosing the Case with wrong index");

	}

	@AfterAll
	static void clean() throws JAXBException {
		PsuDao psuDao1 = new PsuDao();
		psuDao1.setDefaultComponents();
	}

}
