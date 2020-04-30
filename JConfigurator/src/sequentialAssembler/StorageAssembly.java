package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class StorageAssembly extends ComponentAssembly{
	ComponentAssembly getPrevoiusPassage() {
		return new CaseAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new PsuAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		// TODO Auto-generated method stub
		
	}

}
