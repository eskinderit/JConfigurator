package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;


import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class SelectRam extends SelectComponent{
	private RamDao ram ;
	public SelectRam() {
		this.ram=new RamDao();
	}
	
	@Override
	public void readComponent() throws JAXBException{
		System.out.println("Select a Ram:\n");
		for(Ram r:ram.readComponents()) {
			System.out.println(r);
		}
		
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		f.ram(ram.readComponents().get(n));
	}


	@Override
	public ArrayList<Ram> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Ram> ramList = new ArrayList<Ram>();
		if(f.getMyMotherboard() != null) {
			ramList=CompatibilityCheckAlgs.getCompatibleRamsByMotherboard(f);
		}
		else
			ramList=ram.readComponents();

		System.out.println("Select a ram from list:\n");
		for(Ram r:ramList) {
			System.out.println(r);
		}
		
		return ramList;
	}
}
