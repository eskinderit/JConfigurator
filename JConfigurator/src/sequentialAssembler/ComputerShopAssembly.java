package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.ComputerShop;
import configuratorEngine.FullConfig;
import dataSource.ComputerShopDao;

public class ComputerShopAssembly extends ComponentAssembly<ComputerShop> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		ComputerShopDao computerShopDao = new ComputerShopDao();
		ComputerShop componentToSet = computerShopDao.getComponent(index);
		f1.setComputerShop(componentToSet);
	}

	@Override
	public ArrayList<ComputerShop> getCompatibleComponents(FullConfig f1) throws JAXBException {

		ComputerShopDao computerShopDao = new ComputerShopDao();
		return computerShopDao.readComponents();

	}
}
