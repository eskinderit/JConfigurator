package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;
import sequentialAssembler.CompatibilityCheckAlgs;

class CompatibilityCheckAlgsTest {
	
	@Test
	void testCheckMotherboardRam() {
		
		Motherboard motherboard = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram1 = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2 = new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR4", 8);
		
		assertTrue(CompatibilityCheckAlgs.checkMotherboardRam(motherboard, ram1));
		assertFalse(CompatibilityCheckAlgs.checkMotherboardRam(motherboard, ram2));
	
		
	}
	
	@Test
	void testCheckMotherboardCase() {
		
		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Motherboard motherboard3 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 2);
		Case case1 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 3);
		Case case2 = new Case("Kingston HyperX Fury DDR3 (2x4)", 67, 10, 2);
		
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCase(motherboard1, case1));
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCase(motherboard2, case2));
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCase(motherboard3, case2));
		
	}
	
	@Test
	void testCheckMotherboardCpu() {
		
		Motherboard motherboard1 = new Motherboard("MSI Basem", 66, 10, "LGA1151", "H110", "DDR3", false, 1);
		Motherboard motherboard2 = new Motherboard("Gigabyte ga-ab359m-g3 (AM4 DDR4)", 96, 10, "AM4", "ab359m", "DDR4", true, 3);
		Cpu cpu1 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("AMD Ryzen 5 1400 (AM4)", 176, 10, "AM4", true);

		
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCpu(cpu1, motherboard1));
		assertTrue(CompatibilityCheckAlgs.checkMotherboardCpu(cpu2, motherboard2));
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCpu(cpu2, motherboard1));
		assertFalse(CompatibilityCheckAlgs.checkMotherboardCpu(cpu1, motherboard2));
	
	}
	
	@Test
	void testCheckPsu() {
		
		FullConfigBuilder fullConfig = FullConfigBuilder.getIstance();
		
		Cpu cpu = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Gpu gpu = new Gpu("ASUS GTX 1050 2GB", 130, 85, 2);
		Motherboard motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Case case0 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		Storage storage = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);

		
		fullConfig.cpu(cpu);
		fullConfig.gpu(gpu);
		fullConfig.motherboard(motherboard);
		fullConfig.ram(ram);
		fullConfig.case1(case0);
		fullConfig.storage(storage);
		
		
	
		Psu psu1 = new Psu("XFX XTR 550W", 85, 550);
		Psu psu2 = new Psu("China Corporate", 20, 150);
		Psu psu3 = new Psu("Antec", 18, 184);
		
		System.out.println(fullConfig.getTotalEstimatedPower());
		assertTrue(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig,psu1), "Correctly sized Psu Check");
		assertFalse(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig,psu2),"undersized Psu Check");
		assertFalse(CompatibilityCheckAlgs.checkTotalWattagePsu(fullConfig,psu3),"undersized Psu Check");
		
	}
	

	@Test 
	void testCustomerControllerConstructor() {
		
		Cpu cpu = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Gpu gpu = new Gpu("ASUS GTX 1050 2GB", 130, 85, 2);
		Motherboard motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Case case0 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		Storage storage = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);
		Psu psu = new Psu("XFX XTR 550W", 85, 550);
		
		FullConfigBuilder fc = FullConfigBuilder.getIstance();
		
		fc.cpu(cpu);
		fc.gpu(gpu);
		fc.motherboard(motherboard);
		fc.ram(ram);
		fc.case1(case0);
		fc.storage(storage);
		fc.psu(psu);
		
		assertEquals(CompatibilityCheckAlgs.getTotalPrice(fc),664);
		assertEquals(CompatibilityCheckAlgs.getTotalPowerOverstimation(fc),185);
		
		System.out.print(fc);
		System.out.print("\n"+CompatibilityCheckAlgs.getTotalPowerOverstimation(fc));
		System.out.print("\n"+CompatibilityCheckAlgs.getTotalPrice(fc) + " €");
		
	}
	

	
}