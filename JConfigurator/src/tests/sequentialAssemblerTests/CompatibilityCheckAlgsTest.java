package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import configuratorEngine.Case;
import configuratorEngine.Cpu;
import configuratorEngine.FullConfig;
import configuratorEngine.Gpu;
import configuratorEngine.Motherboard;
import configuratorEngine.Psu;
import configuratorEngine.Ram;
import configuratorEngine.Storage;
import sequentialAssembler.CompatibilityCheckAlgs;

class CompatibilityCheckAlgsTest {

	@Test
	void testCheckMotherboardRam() {

		Motherboard motherboard = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram1 = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2 = new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR4", 8);

		assertTrue(CompatibilityCheckAlgs.checkMotherboardRam(motherboard, ram1),
				"Comparing compatible Ram and Motherboard (Same socket)");
		assertFalse(CompatibilityCheckAlgs.checkMotherboardRam(motherboard, ram2),
				"Comparing incompatible Ram and Motherboard (different socket)");

	}

	@Test
	void testCheckMotherboardCase() {

		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Motherboard motherboard3 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 2);
		Case case1 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 3);
		Case case2 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 2);

		assertTrue(CompatibilityCheckAlgs.checkMotherboardCase(motherboard1, case1),
				"Comparing compatible Motherboard and Case: bigger (size) Case");
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCase(motherboard2, case2),
				"Comparinf incompatible Motherboard and Case: smaller (size) Case");
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCase(motherboard3, case2),
				"Comparing compatible Motherboard and case: same size");

	}

	@Test
	void testCheckMotherboardCpu() {

		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("Gigabyte ga-ab359m-g3 (AM4 DDR4)", 96, 10, "AM4", "ab359m", "DDR4",
				true, 3);
		Cpu cpu1 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("AMD Ryzen 5 1400 (AM4)", 176, 10, "AM4", true);

		assertTrue(CompatibilityCheckAlgs.checkMotherboardCpu(cpu1, motherboard1),
				"Checking compatible Motherboard and Cpu: same socket");
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCpu(cpu2, motherboard2),
				"Checking compatible Motherboard and Cpu: same socket");
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCpu(cpu2, motherboard1),
				"Checking incompatible Motherboard and Cpu: different socket");
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCpu(cpu1, motherboard2),
				"Checking incompatible Motherboard and Cpu: different socket");

	}

	@Test
	void testCheckPsu() {

		FullConfig fullConfig = new FullConfig();

		Cpu cpu = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Gpu gpu = new Gpu("ASUS GTX 1050 2GB", 130, 85, 2);
		Motherboard motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false,
				3);
		Ram ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Case case0 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		Storage storage = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);

		fullConfig.setCpu(cpu);
		fullConfig.setGpu(gpu);
		fullConfig.setMotherboard(motherboard);
		fullConfig.setRam(ram);
		fullConfig.setCase0(case0);
		fullConfig.setStorage(storage);

		Psu psu1 = new Psu("XFX XTR 550W", 85, 550);
		Psu psu2 = new Psu("China Corporate", 20, 150);
		Psu psu3 = new Psu("Antec", 18, 184);

		assertTrue(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig, psu1),
				"Correctly sized (in power) Psu Check");
		assertFalse(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig, psu2),
				"checking undersized (in power) Psu Check");
		assertFalse(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig, psu3),
				"checking undersized (in power) Psu Check");

	}

}