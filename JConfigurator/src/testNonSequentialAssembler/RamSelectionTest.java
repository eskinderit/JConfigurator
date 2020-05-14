package testNonSequentialAssembler;

import nonSequentialAssembler.RamSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Ram;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;


public class RamSelectionTest {
	FullConfigBuilder f;
	RamSelection rams;
	
	@BeforeEach
	public void init() throws JAXBException{
		f = new FullConfigBuilder();
		rams = new RamSelection();
	}
	
	@Test
	public void compatibleRams() throws JAXBException {
		Motherboard m = new Motherboard("Name", 60, 60, "LGA1151", "H110", "DDR3", true, 10);
		f.motherboard(m);
		for(Ram r:rams.getCompatibleComponents(f)) {
			assertEquals(r.getRamType(), f.getMyMotherboard().getRamType(),  "Test compatible rams");
			assertEquals(r.getRamType(), m.getRamType(),  "Test compatible rams");
		}
	}
}
