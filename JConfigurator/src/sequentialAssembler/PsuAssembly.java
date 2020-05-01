package sequentialAssembler;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Psu;
import dataSource.PsuDao;


public class PsuAssembly extends ComponentAssembly{
	ComponentAssembly getPrevoiusPassage() {
		return new StorageAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new ComputerShopAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		PsuDao psuDao = new PsuDao(); 
		Psu componentToSet = psuDao.getComponent(index);
		f1.setMyPsu(componentToSet);
	}

}
