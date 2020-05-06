package sequentialAssembler;


import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import dataSource.ComponentDao;
import dataSource.GpuDao;

public class GpuAssembly extends ComponentAssembly {


	@Override
public	ComponentAssembly getPreviousPassage() {
		return new CpuAssembly();
	}
	@Override
public ComponentAssembly getNextPassage() {
		return new MotherboardAssembly();
	}
	
	@Override
	protected void passageBehavior(FullConfigBuilder f1, int index) throws JAXBException {
		GpuDao gpuDao = new GpuDao(); 
		Gpu componentToSet = gpuDao.getComponent(index);
		f1.gpu(componentToSet);
	}
	
	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new GpuDao();
	}
	@Override
	public ArrayList<Gpu> getCompatibleComponents(FullConfigBuilder f1) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		return gpuDao.readComponents();
	}


}


