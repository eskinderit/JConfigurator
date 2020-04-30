package sequentialAssembler;

import ConfiguratorEngine.FullConfig;

public class MotherboardAssembly extends ComponentAssembly{

	
	ComponentAssembly getPrevoiusPassage() {
		return new GpuAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new RamAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		// TODO Auto-generated method stub
		
	}

}
