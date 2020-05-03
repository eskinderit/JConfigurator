package sequentialAssembler;


import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Gpu;
import dataSource.ComponentDao;
import dataSource.GpuDao;

public class GpuAssembly extends ComponentAssembly{


	@Override
public	ComponentAssembly getPreviousPassage() {
		return new CpuAssembly();
	}
	@Override
public ComponentAssembly getNextPassage() {
		return new MotherboardAssembly();
	}
	
	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		GpuDao gpuDao = new GpuDao(); 
		Gpu componentToSet = gpuDao.getComponent(index);
		f1.setMyGpu(componentToSet);
	}
	
	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new GpuDao();
	}


}


