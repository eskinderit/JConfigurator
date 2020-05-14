package testNonSequentialAssembler;

import nonSequentialAssembler.CaseSelection;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;

public class CaseSelectionTest {
	FullConfigBuilder f;
	CaseSelection cases;
	
	@BeforeEach
	public void init() throws JAXBException{
		f = new FullConfigBuilder();
		cases = new CaseSelection();
	}
	
	@Test
	public void compatibleCases() throws JAXBException {
		Motherboard m = new Motherboard("Name", 60, 60, "LGA1151", "H110", "DDR3", true, 2);
		f.motherboard(m);
		for(Case c:cases.getCompatibleComponents(f)) {
			assertTrue(c.getSize()>=f.getMyMotherboard().getSize(), "Test compatible cases");
			assertTrue(c.getSize()>=m.getSize(), "Test compatible cases");
		}
	}
}
