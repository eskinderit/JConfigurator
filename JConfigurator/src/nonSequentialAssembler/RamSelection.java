package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class RamSelection implements ComponentSelection{
	private RamDao ramList;
	private int size;
	
	
	public RamSelection() {
		ramList = new RamDao();
	}

	@Override
	public ArrayList<Ram> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Ram> rams = new ArrayList<Ram>();
		if(f.getMyMotherboard() != null) {
			rams=CompatibilityCheckAlgs.getCompatibleRamsByMotherboard(f);
		}
		else
			rams=ramList.readComponents();
		
		size=rams.size();
		
		return rams;
	}

	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}
