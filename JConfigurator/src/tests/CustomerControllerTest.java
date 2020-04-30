package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Cpu;

import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;
import ConfiguratorEngine.Case;
import configurationController.CustomerController;
class CustomerControllerTest {

	CustomerController c1 = new CustomerController();
	
	
	@Test 
	void testCustomerControllerConstructor() {
		
		Cpu cpu = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Gpu gpu = new Gpu("ASUS GTX 1050 2GB", 130, 85, 2);
		Motherboard motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		Ram ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Case case0 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		Storage storage = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);
		Psu psu = new Psu("XFX XTR 550W", 85, 550);
		
		c1.getFullConfig().setMyCpu(cpu);
		c1.getFullConfig().setMyGpu(gpu);
		c1.getFullConfig().setMyMotherboard(motherboard);
		c1.getFullConfig().setMyRam(ram);
		c1.getFullConfig().setMyCase1(case0);
		c1.getFullConfig().setMyStorage(storage);
		c1.getFullConfig().setMyPsu(psu);
		
		assertEquals(c1.getTotalPrice(),664);
		assertEquals(c1.getTotalPowerOverstimation(),185);
		
		System.out.print(c1.getFullConfig());
		System.out.print("\n"+c1.getTotalPrice());
		System.out.print("\n"+c1.getFullConfig().getTotalPrice() + " €");
		
	}
	

	


}
