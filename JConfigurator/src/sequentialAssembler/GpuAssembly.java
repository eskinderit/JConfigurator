package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Gpu;
import dataSource.ComponentDao;
import dataSource.GpuDao;

public class GpuAssembly extends ComponentAssembly<Gpu> {

	@Override
	public ComponentAssembly<?> getPreviousPassage() {
		return new CpuAssembly();
	}

	@Override
	public ComponentAssembly<?> getNextPassage() {
		return new MotherboardAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		Gpu componentToSet = gpuDao.getComponent(index);
		f1.setGpu(componentToSet);
	}

	@Override
	public ComponentDao<Gpu, GpuDao> getComponentDao() {
		return new GpuDao();
	}

	@Override
	public ArrayList<Gpu> getCompatibleComponents(FullConfig f1) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		return gpuDao.readComponents();
	}

}
