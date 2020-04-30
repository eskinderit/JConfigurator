package sequentialAssembler;


import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Gpu;

import dataSource.GpuDao;

public class GpuAssembly extends ComponentAssembly{

	GpuAssembly(){
		super();

}

	@Override
	protected void passageBehavior(FullConfig f1, int index) {
		GpuDao gpuDao = new GpuDao(); 
		Gpu componentToSet = gpuDao.getComponent(index);
		f1.setMyGpu(componentToSet);
	}
		
	ComponentAssembly getPrevoiusPassage() {
		return new CpuAssembly();
	}
	
	ComponentAssembly getNextPassage() {
		return new MotherboardAssembly();
	}


}


