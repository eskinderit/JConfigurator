package sequentialAssembler;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Psu;
import dataSource.ComponentDao;
import dataSource.PsuDao;


public class PsuAssembly extends ComponentAssembly{
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

}
