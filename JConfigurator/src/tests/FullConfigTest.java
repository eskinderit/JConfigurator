package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;

class FullConfigTest {
	
	@Test
	void testCheckMotherboardRam() {
		
		Motherboard motherboard = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram1 = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2 = new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR4", 8);
		
		assertTrue(FullConfig.checkMotherboardRam(motherboard, ram1));
		assertFalse(FullConfig.checkMotherboardRam(motherboard, ram2));
	
		
	}
	
	@Test
	void testCheckMotherboardCase() {
		
		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Motherboard motherboard3 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 2);
		Case case1 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 3);
		Case case2 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 2);
		
		assertTrue(FullConfig.checkMotherboardCase(motherboard1, case1));
		assertFalse(FullConfig.checkMotherboardCase(motherboard2, case2));
		assertTrue(FullConfig.checkMotherboardCase(motherboard3, case2));
		
	}
	
	@Test
	void testCheckMotherboardCpu() {
		
		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("Gigabyte ga-ab359m-g3 (AM4 DDR4)", 96, 10, "AM4", "ab359m", "DDR4", true, 3);
		Cpu cpu1 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("AMD Ryzen 5 1400 (AM4)", 176, 10, "AM4", true);

		
		assertTrue(FullConfig.checkMotherboardCpu(cpu1, motherboard1));
		assertTrue(FullConfig.checkMotherboardCpu(cpu2, motherboard2));
		assertFalse(FullConfig.checkMotherboardCpu(cpu2, motherboard1));
		assertFalse(FullConfig.checkMotherboardCpu(cpu1, motherboard2));
	
	}
	
	@Test
	void testCheckPsu() {
		
		FullConfig fullConfig = FullConfig.getIstance();
		
		Cpu cpu = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Gpu gpu = new Gpu("ASUS GTX 1050 2GB", 130, 85, 2);
		Motherboard motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Case case0 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		Storage storage = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);

		
		fullConfig.setMyCpu(cpu);
		fullConfig.setMyGpu(gpu);
		fullConfig.setMyMotherboard(motherboard);
		fullConfig.setMyRam(ram);
		fullConfig.setMyCase1(case0);
		fullConfig.setMyStorage(storage);
		
		
	
		Psu psu1 = new Psu("XFX XTR 550W", 85, 550);
		Psu psu2 = new Psu("China Corporate", 20, 150);
		Psu psu3 = new Psu("Antec", 18, 184);
		
		
		assertTrue(FullConfig.checkTotalWattagePsu(fullConfig,psu1));
		assertFalse(FullConfig.checkTotalWattagePsu(fullConfig,psu2));
		assertFalse(FullConfig.checkTotalWattagePsu(fullConfig,psu3));
		
	}
	
	
	
}