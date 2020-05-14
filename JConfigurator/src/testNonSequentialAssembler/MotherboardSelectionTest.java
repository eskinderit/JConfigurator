package testNonSequentialAssembler;

import nonSequentialAssembler.MotherboardSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Ram;


public class MotherboardSelectionTest {
	FullConfigBuilder f;
	MotherboardSelection motherboards;
	
	@BeforeEach
	public void init() throws JAXBException{
		f = new FullConfigBuilder();
		motherboards = new MotherboardSelection();
	}
	
	@Test
	public void compatibleMotherboards() throws JAXBException {
		Cpu c = new Cpu("Name", 60, 60, "LGA1151", true);
		f.cpu(c);
		for(Motherboard m : motherboards.getCompatibleComponents(f)) {
			assertEquals(m.getSocket(), c.getSocket(), "Test compatible motherboards from cpu");
			assertEquals(m.getSocket(), f.getMyCpu().getSocket(), "Test compatible motherboards from cpu");
		}
		Ram r = new Ram("ram1", 123, 23, "DDR3", 20);
		f.ram(r);
		for(Motherboard m : motherboards.getCompatibleComponents(f)) {
			assertEquals(m.getRamType(), r.getRamType());
			assertEquals(m.getRamType(), f.getMyRam().getRamType(),  "Test compatible motherboards from ram");
			assertEquals(m.getSocket(), f.getMyCpu().getSocket(),  "Test compatible motherboards from ram");
		}
		
		Case case1 = new Case("Case1", 23, 23, 2);
		f.case1(case1);
		for(Motherboard m : motherboards.getCompatibleComponents(f)) {
			assertEquals(m.getRamType(), f.getMyRam().getRamType(),  "Test compatible motherboards from case");
			assertEquals(m.getSocket(), f.getMyCpu().getSocket(),  "Test compatible motherboards from case");
			assertTrue(m.getSize()<=case1.getSize(),  "Test compatible motherboards from case");
			
		}
	}
}
