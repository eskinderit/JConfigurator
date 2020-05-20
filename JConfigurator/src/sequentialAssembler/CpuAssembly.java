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
	public ComponentDao<Cpu, CpuDao> getComponentDao() {
		return new CpuDao();
	}

	@Override
	public ArrayList<Cpu> getCompatibleComponents(FullConfig f1) throws JAXBException {
		if (f1.getMotherboard() != null)
			return this.getCompatibleCpusByMotherboard(f1);
		else {
			CpuDao cpuDao = new CpuDao();
			return cpuDao.readComponents();
		}

	}

	private ArrayList<Cpu> getCompatibleCpusByMotherboard(FullConfig f1) throws JAXBException {

		ArrayList<Cpu> compatibleCpus = new ArrayList<Cpu>();
		CpuDao cpuDao = new CpuDao();
		for (Cpu c : cpuDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardCpu(c, f1.getMotherboard()))
				compatibleCpus.add(c);
		}
		return compatibleCpus;
	}

}
