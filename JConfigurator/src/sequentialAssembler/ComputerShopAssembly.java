package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class ComputerShopAssembly extends ComponentAssembly{
	
	ComponentAssembly getPrevoiusPassage() {
		return new CpuAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return null;
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		//TODO implement the ComputerShopDao
	}


}
