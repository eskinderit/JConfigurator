package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.FullConfigBuilder;
import dataSource.PsuDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class SelectPsu extends SelectComponent{
private PsuDao psu;
	
	public SelectPsu() {
		psu=new PsuDao();
	}
	
	
	@Override
	public void readComponent() throws JAXBException{
		System.out.println("Select a Psu from list:\n");
		for(Psu p:psu.readComponents()) {
			System.out.println(p);
		}
		
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		f.psu(psu.readComponents().get(n));
	}

	
	@Override
	public ArrayList<Psu> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList <Psu> psuList = new ArrayList<Psu>();
		psuList = CompatibilityCheckAlgs.getCompatiblePsu(f);
		
		System.out.println("Select a psu from list: ");
		for(Psu p:psuList) {
			System.out.println(p);
		}
		return psuList;
	}
}
