package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Psu;
import sequentialAssembler.CompatibilityCheckAlgs;

public class PsuSelection implements ComponentSelection{
	private int size=0;
	@Override
	public ArrayList<Psu> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		size = CompatibilityCheckAlgs.getCompatiblePsu(f).size();
		return CompatibilityCheckAlgs.getCompatiblePsu(f);
	}
	@Override
	public int getSize() throws JAXBException {
		return size;
	} 
	
	
}
