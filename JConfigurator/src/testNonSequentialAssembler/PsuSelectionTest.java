package testNonSequentialAssembler;

import nonSequentialAssembler.PsuSelection;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;

public class PsuSelectionTest {
	FullConfigBuilder f;
	Cpu cpu;
	Motherboard motherboard;
	Ram ram;
	Gpu gpu;
	Case case1;
	Storage storage;
	FullConfig fullConfig;
	
	@BeforeEach
	public void init() {
		f = new FullConfigBuilder();
		cpu = new Cpu("Intel Pentium G4520 (lga 1151)", 95, 10, "LGA1151", true);
		motherboard = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3);
		ram = new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		gpu = new Gpu("Palit Titan Z 12GB", 1170, 490, 12);
		case1 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);
		storage = new Storage("Samsung 850 evo 250GB (SSD)", 153, 10, 250, true);
		f.cpu(cpu);
		f.gpu(gpu);
		f.case1(case1);
		f.ram(ram);
		f.storage(storage);
		f.motherboard(motherboard);
		fullConfig = f.buildFullConfig();
	}
	
	@Test
	public void compatiblePsus() throws JAXBException {
		PsuSelection psuList = new PsuSelection();
		
		for(Psu p:psuList.getCompatibleComponents(f) )
		assertTrue(p.getPower() >= fullConfig.getTotalPower()+50, "Test compatible psus");
	}
}