package sequentialAssembler;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Motherboard;
import dataSource.ComponentDao;
import dataSource.MotherboardDao;


public class MotherboardAssembly extends ComponentAssembly{

	@Override
public	ComponentAssembly getPreviousPassage() {
		return new GpuAssembly();
	}
	
	@Override
public	ComponentAssembly getNextPassage() {
		return new RamAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao(); 
		Motherboard componentToSet = motherboardDao.getComponent(index);
		f1.setMyMotherboard(componentToSet);
		
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new MotherboardDao();
	}
}
