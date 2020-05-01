package sequentialAssembler;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import dataSource.CpuDao;

public class CpuAssembly extends ComponentAssembly{
	
CpuAssembly(){
		super();
		this.previousPassage= null;
}

ComponentAssembly getPrevoiusPassage() {
	return null;
}

ComponentAssembly getNextPassage() {
	return new GpuAssembly();
}


@Override
protected void passageBehavior(FullConfig f1, int index) {	
	CpuDao cpuDao = new CpuDao(); 
	Cpu componentToSet = cpuDao.getComponent(index);
	f1.setMyCpu(componentToSet);
	}
}
