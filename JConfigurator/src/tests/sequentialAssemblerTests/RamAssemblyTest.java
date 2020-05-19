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

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.RamAssembly;

class RamAssemblyTest {

	ComponentAssembly<Ram> ramAssembly;
	RamDao ramDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		ramAssembly = new RamAssembly();
		ramDao = new RamDao();
		ramDao.setEmptyComponents();
		f1 = new FullConfig();
	}

	@Test
	void getCompatibleComponentsTest() throws JAXBException {
		Ram ram0 = new Ram("Prova0", 2, 3, "DDR3", 1);
		Ram ram1 = new Ram("Prova1", 15, 26, "DDR4", 2);

		ArrayList<Ram> ramList = new ArrayList<>();
		ramList.add(ram0);
		ramList.add(ram1);

		ramDao.addComponents(ramList);
		Motherboard motherboard = new Motherboard("MotherboardProva", 43, 3, "LGA1150", "Z77", "DDR3", false, 2);

		f1.setMotherboard(motherboard);

		ArrayList<Ram> compatibleComponents = ramAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(ram1),
				"Verifying the incompatibility of a ram with different ramType");
		assertTrue(compatibleComponents.contains(ram0), "Verifying the compatibility of a ram with different ramType");
	}

	@Test
	void getComponentsByIndex() throws JAXBException {
		Ram ram0 = new Ram("Prova0", 2, 3, "DDR3", 1);
		Ram ram1 = new Ram("Prova1", 15, 26, "DDR4", 2);

		ArrayList<Ram> ramList = new ArrayList<>();
		ramList.add(ram0);
		ramList.add(ram1);

		ramDao.addComponents(ramList);

		FullConfig f1 = new FullConfig();
		ramAssembly.InputBasedBehavior(ramAssembly, f1, "0");
		assertEquals(f1.getRam(), ram0, "Comparing the Case with right index");
		assertNotEquals(f1.getRam(), ram1, "Choosing the Case with wrong index");

	}

	@AfterAll
	static void clean() throws JAXBException {
		RamDao ramDao1 = new RamDao();
		ramDao1.setDefaultComponents();
	}

}
