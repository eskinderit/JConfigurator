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

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Motherboard;
import dataSource.CpuDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.CpuAssembly;

class CpuAssemblyTest {

	ComponentAssembly<Cpu> cpuAssembly;
	CpuDao cpuDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		cpuAssembly = new CpuAssembly();
		cpuDao = new CpuDao();
		cpuDao.setEmptyComponents();
		f1 = new FullConfig();
	}

	@Test
	void getCompatibleComponentsTest() throws JAXBException {

		Cpu cpu0 = new Cpu("Prova0", 0, 0, "AM4", true);
		Cpu cpu1 = new Cpu("Prova1", 0, 0, "LGA1150", true);
		Cpu cpu2 = new Cpu("Prova2", 0, 0, "LGA1151", true);
		Cpu cpu3 = new Cpu("Prova3", 0, 0, "AM4", true);

		ArrayList<Cpu> cpuList = new ArrayList<>();
		cpuList.add(cpu0);
		cpuList.add(cpu1);
		cpuList.add(cpu2);
		cpuList.add(cpu3);

		cpuDao.addComponents(cpuList);
		Motherboard motherboard = new Motherboard("MotherboardProva", 43, 3, "LGA1150", "Z77", "DDR3", false, 2);

		f1.setMotherboard(motherboard);

		ArrayList<Cpu> compatibleComponents = cpuAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(cpu0),
				"Comparing incompatible Motherboard and Cpu: different sockets");
		assertTrue(compatibleComponents.contains(cpu1), "Comparing compatible Motherboard and Cpu: same sockets");
		assertFalse(compatibleComponents.contains(cpu2),
				"Comparing incompatible Motherboard and Cpu: different sockets");
		assertFalse(compatibleComponents.contains(cpu3),
				"Comparing incompatible Motherboard and Cpu: different sockets");

	}

	@Test
	void getComponentsByIndex() throws JAXBException {
		Cpu cpu0 = new Cpu("Prova0", 0, 0, "AM4", true);
		Cpu cpu1 = new Cpu("Prova1", 0, 0, "AM4", true);
		Cpu cpu2 = new Cpu("Prova2", 0, 0, "AM4", true);
		Cpu cpu3 = new Cpu("Prova3", 0, 0, "AM4", true);

		ArrayList<Cpu> cpuList = new ArrayList<>();
		cpuList.add(cpu0);
		cpuList.add(cpu1);
		cpuList.add(cpu2);
		cpuList.add(cpu3);

		cpuDao.addComponents(cpuList);
		Motherboard m1 = new Motherboard("Prova Mobo", 15, 22, "AM4", "FX567", "DDR3", false, 3);
		f1.setMotherboard(m1);
		cpuAssembly.InputBasedBehavior(cpuAssembly, f1, "0");
		assertEquals(f1.getCpu(), cpu0, "Comparing the Case with right index");
		assertNotEquals(f1.getCpu(), cpu1, "Choosing the Case with wrong index");

	}

	@AfterAll
	static void clean() throws JAXBException {
		CpuDao cpuDao1 = new CpuDao();
		cpuDao1.setDefaultComponents();
	}

}
