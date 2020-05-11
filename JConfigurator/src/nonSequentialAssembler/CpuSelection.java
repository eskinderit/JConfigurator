package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import dataSource.CpuDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class CpuSelection implements ComponentSelection{
	private CpuDao cpuList;
	private int size;


	public CpuSelection() {
		cpuList = new CpuDao();
	}


	@Override
	public ArrayList<Cpu> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Cpu> cpus = new ArrayList<Cpu>();
		if(f.getMyMotherboard() != null) {
			cpus=CompatibilityCheckAlgs.getCompatibleCpusByMotherboard(f);
		}
		else
			cpus=cpuList.readComponents();

		size = cpus.size();
		return cpus;
	}

	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}

