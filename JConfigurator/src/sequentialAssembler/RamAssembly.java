package sequentialAssembler;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Ram;
import dataSource.ComponentDao;
import dataSource.RamDao;

public class RamAssembly extends ComponentAssembly{

	@Override
	public	ComponentAssembly getPreviousPassage() {
		return new MotherboardAssembly();
	}

	@Override
	public	ComponentAssembly getNextPassage() {
		return new CaseAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		RamDao ramDao = new RamDao(); 
		Ram componentToSet = ramDao.getComponent(index);
		f1.setMyRam(componentToSet);
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new RamDao();
	}
}
