package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.FullConfig;
import configuratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuAssembly extends ComponentAssembly<Gpu> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		Gpu componentToSet = gpuDao.getComponent(index);
		f1.setGpu(componentToSet);
	}

	@Override
	public ArrayList<Gpu> getCompatibleComponents(FullConfig f1) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		return gpuDao.readComponents();
	}

}
