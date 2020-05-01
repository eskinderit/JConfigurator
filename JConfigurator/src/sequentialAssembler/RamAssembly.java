package sequentialAssembler;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;

public class RamAssembly extends ComponentAssembly{
	
	ComponentAssembly getPrevoiusPassage() {
		return new MotherboardAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new CaseAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		RamDao ramDao = new RamDao(); 
		Ram componentToSet = ramDao.getComponent(index);
		f1.setMyRam(componentToSet);
	}

}
