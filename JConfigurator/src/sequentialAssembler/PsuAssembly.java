package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class PsuAssembly extends ComponentAssembly{
	ComponentAssembly getPrevoiusPassage() {
		return new StorageAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new ComputerShopAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		// TODO Auto-generated method stub
		
	}

}
