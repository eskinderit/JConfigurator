package testNonSequentialAssembler;

import nonSequentialAssembler.CpuSelection;

import static org.junit.Assert.assertEquals;
import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;



public class CpuSelectionTest {
	FullConfigBuilder f;
	CpuSelection cpus;
	
	@BeforeEach
	public void init() throws JAXBException{
		f = new FullConfigBuilder();
		cpus = new CpuSelection();
	}
	
	@Test
	public void compatibleCpus() throws JAXBException {
		Motherboard m = new Motherboard("Name", 60, 60, "LGA1151", "H110", "DDR3", true, 10);
		f.motherboard(m);
		for(Cpu c:cpus.getCompatibleComponents(f)) {
			assertEquals(c.getSocket(), f.getMyMotherboard().getSocket(), "Test compatible cpus");
			assertEquals(c.getSocket(), m.getSocket(), "Test compatible cpus");
		}
	}
	
}
