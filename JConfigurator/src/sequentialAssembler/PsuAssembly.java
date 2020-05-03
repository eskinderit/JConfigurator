package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Psu;
import dataSource.ComponentDao;
import dataSource.PsuDao;


public class PsuAssembly extends ComponentAssembly {
	@Override
public	ComponentAssembly getPreviousPassage() {
		return new StorageAssembly();
	}
	
	@Override
	public	ComponentAssembly getNextPassage() {
		return new ComputerShopAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		PsuDao psuDao = new PsuDao(); 
		Psu componentToSet = psuDao.getComponent(index);
		f1.setMyPsu(componentToSet);
	}
	
	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new PsuDao();
	}

	@Override
	public ArrayList<Psu> getCompatibleComponents(FullConfig f1) throws JAXBException {
		
		if((f1.getMyCpu() != null) && (f1.getMyGpu() != null) && (f1.getMyMotherboard()!=null) && (f1.getMyRam() != null) && (f1.getMyCase1() != null) && (f1.getMyStorage()!=null))
		{
				return CompatibilityCheckAlgs.getCompatiblePsu(f1);
		}
		else
			return null;

	}
	
	

}
