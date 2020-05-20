package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.Cpu;
import configuratorEngine.FullConfig;
import dataSource.CpuDao;

public class CpuAssembly extends ComponentAssembly<Cpu> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		CpuDao cpuDao = new CpuDao();
		Cpu componentToSet = cpuDao.getComponent(index);
		f1.setCpu(componentToSet);
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
