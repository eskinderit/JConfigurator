package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Cpu;

import dataSource.CpuDao;

public class CpuDataManagement extends ComponentDataManagement{
	
	
	

	@Override
	public ArrayList<Cpu> deleteComp(int index) throws JAXBException {
		ArrayList<Cpu> cpus = new ArrayList<Cpu>();
		CpuDao cpuDao = new CpuDao();
		cpus.add(cpuDao.readComponents().get(index));
		cpuDao.deleteComponents(cpus);
		
		return cpuDao.readComponents();
	}
}
