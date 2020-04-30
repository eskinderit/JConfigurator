package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class CaseAssembly extends ComponentAssembly{

	ComponentAssembly getPrevoiusPassage() {
		return new RamAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new StorageAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		// TODO Auto-generated method stub
		
	}

	
}
