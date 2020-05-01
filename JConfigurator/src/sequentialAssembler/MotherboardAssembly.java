package sequentialAssembler;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;


public class MotherboardAssembly extends ComponentAssembly{

	
	ComponentAssembly getPrevoiusPassage() {
		return new GpuAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new RamAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		MotherboardDao motherboardDao = new MotherboardDao(); 
		Motherboard componentToSet = motherboardDao.getComponent(index);
		f1.setMyMotherboard(componentToSet);
		
	}

}
