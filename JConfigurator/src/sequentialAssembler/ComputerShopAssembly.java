package sequentialAssembler;


import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.ComputerShop;
import ConfiguratorEngine.FullConfigBuilder;
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
	protected void setComponentByIndex(FullConfigBuilder f1, int index) throws JAXBException {

		ComputerShopDao computerShopDao = new ComputerShopDao(); 
		ComputerShop componentToSet = computerShopDao.getComponent(index);

		f1.setComputerShop(componentToSet);

	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new ComputerShopDao();
	}
	
	@Override
	public ArrayList<ComputerShop> getCompatibleComponents(FullConfigBuilder f1) throws JAXBException {
		
		ComputerShopDao computerShopDao = new ComputerShopDao();
		return computerShopDao.readComponents();

	}
}
