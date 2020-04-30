package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class RamAssembly extends ComponentAssembly{
	
	ComponentAssembly getPrevoiusPassage() {
		return new MotherboardAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new CaseAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		// TODO Auto-generated method stub
		
	}

}
