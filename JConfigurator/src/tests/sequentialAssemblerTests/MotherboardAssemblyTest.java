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
import configuratorEngine.Motherboard;
import configuratorEngine.Ram;
import dataSource.MotherboardDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.MotherboardAssembly;

class MotherboardAssemblyTest {

	ComponentAssembly<Motherboard> motherboardAssembly;
	MotherboardDao motherboardDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		motherboardAssembly = new MotherboardAssembly();
		motherboardDao = new MotherboardDao();
		motherboardDao.setEmptyComponents();
		f1 = new FullConfig();
	}

	@Test
	void getCompatibleComponentsTestBySocket() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3",
				false, 3);
		Motherboard motherboard2 = new Motherboard("Asus prime h270 plus (lga1151 DDR4)", 108, 10, "LGA1151", "H270",
				"DDR4", false, 3);
		Motherboard motherboard3 = new Motherboard("MSI b350m (AM4 DDR4)", 89, 10, "AM4", "b350m", "DDR4", true, 3);

		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);
		motherboardList.add(motherboard3);

		motherboardDao.addComponents(motherboardList);
		Cpu cpu = new Cpu("CpuProva", 43, 3, "AM4", false);

		f1.setCpu(cpu);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard1),
				"Comparing incompatible Motherboard and Cpu: different sockets");
		assertTrue(compatibleComponents.contains(motherboard3),
				"Comparing compatible Motherboard and Cpu: same sockets");

	}

	@Test
	void getCompatibleComponentsTestBySize() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Atx", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Motherboard motherboard2 = new Motherboard("MSI uAtx", 108, 10, "LGA1151", "H270", "DDR4", false, 2);
		Motherboard motherboard3 = new Motherboard("MSI mini-itx", 89, 10, "AM4", "b350m", "DDR4", true, 1);

		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);
		motherboardList.add(motherboard3);

		motherboardDao.addComponents(motherboardList);
		Case case1 = new Case("Corsair Mini itx", 55, 10, 1);

		f1.setCase0(case1);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard1),
				"Comparing incompatible Motherboard and Case: Motherboard bigger in size");
		assertFalse(compatibleComponents.contains(motherboard2),
				"Comparing incompatible Motherboard and Case: Motherboard bigger in size");
		assertTrue(compatibleComponents.contains(motherboard3),
				"Comparing compatible Motherboard and Case: Motherboard has equal size to Case");

	}

	@Test
	void getCompatibleComponentsTestByRamType() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3",
				false, 3);
		Motherboard motherboard2 = new Motherboard("Asus prime h270 plus (lga1151 DDR4)", 108, 10, "LGA1151", "H270",
				"DDR4", false, 3);

		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);

		motherboardDao.addComponents(motherboardList);
		Ram ram = new Ram("Ballistix Hyper", 53, 10, "DDR3", 16);

		f1.setRam(ram);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard2),
				"Comparing incompatible Motherboard and Ram: different ramType");
		assertTrue(compatibleComponents.contains(motherboard1),
				"Comparing compatible Motherboard and Ram: same ramType");

	}

	@Test
	void getComponentsByIndex() throws JAXBException {

		Motherboard motherboard0 = new Motherboard("MSI Atx", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Motherboard motherboard1 = new Motherboard("MSI uAtx", 108, 10, "LGA1151", "H270", "DDR4", false, 2);
		Motherboard motherboard2 = new Motherboard("MSI mini-itx", 89, 10, "AM4", "b350m", "DDR4", true, 1);

		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard0);
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);

		motherboardDao.addComponents(motherboardList);

		motherboardAssembly.InputBasedBehavior(f1, "0");
		assertEquals(f1.getMotherboard(), motherboard0, "Comparing the Case with right index");
		assertNotEquals(f1.getMotherboard(), motherboard1, "Choosing the Case with wrong index");

	}

	@AfterAll
	static void clean() throws JAXBException {
		MotherboardDao motherboardDao1 = new MotherboardDao();
		motherboardDao1.setDefaultComponents();
	}

}
