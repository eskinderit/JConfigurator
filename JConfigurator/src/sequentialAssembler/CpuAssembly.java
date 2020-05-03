package sequentialAssembler;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;
import dataSource.CpuDao;

public class CpuAssembly extends ComponentAssembly{

@Override
public ComponentAssembly getPreviousPassage() {
	return null;
}
@Override
public ComponentAssembly getNextPassage() {
	return new GpuAssembly();
}


@Override
protected void passageBehavior(FullConfig f1, int index) throws JAXBException {	
	CpuDao cpuDao = new CpuDao(); 
	Cpu componentToSet = cpuDao.getComponent(index);
	f1.setMyCpu(componentToSet);
	}
@Override
public ComponentDao<?,?> getComponentDao() {
	return new CpuDao();
}

}
