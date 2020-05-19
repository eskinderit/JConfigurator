package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;
import dataSource.CpuDao;

public class CpuAssembly extends ComponentAssembly<Cpu> {

	@Override
	public ComponentAssembly<?> getPreviousPassage() {
		return null;
	}

	@Override
	public ComponentAssembly<?> getNextPassage() {
		return new GpuAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		CpuDao cpuDao = new CpuDao();
		Cpu componentToSet = cpuDao.getComponent(index);
		f1.setCpu(componentToSet);
	}

	@Override
	public ComponentDao<?, ?> getComponentDao() {
		return new CpuDao();
	}

	@Override
	public ArrayList<Cpu> getCompatibleComponents(FullConfig f1) throws JAXBException {
		if (f1.getMotherboard() != null)
			return CompatibilityCheckAlgs.getCompatibleCpusByMotherboard(f1);
		else {
			CpuDao cpuDao = new CpuDao();
			return cpuDao.readComponents();
		}

	}

}
