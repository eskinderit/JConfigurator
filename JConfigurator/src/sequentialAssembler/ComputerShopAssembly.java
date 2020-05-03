package sequentialAssembler;


import javax.xml.bind.JAXBException;

import ConfiguratorEngine.ComputerShop;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;
import dataSource.ComputerShopDao;


public class ComputerShopAssembly extends ComponentAssembly{
	
	@Override
	public ComponentAssembly getPreviousPassage() {
		return new PsuAssembly();
	}
	@Override
	public ComponentAssembly getNextPassage() {
		return null;
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		ComputerShopDao computerShopDao = new ComputerShopDao(); 
		ComputerShop componentToSet = computerShopDao.getComponent(index);
		f1.setMyComputerShop(componentToSet);
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new ComputerShopDao();
	}
}
