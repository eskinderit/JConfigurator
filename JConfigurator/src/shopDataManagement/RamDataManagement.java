package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Ram;
import dataSource.RamDao;

public class RamDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Ram> deleteComp(int index) throws JAXBException {
		ArrayList<Ram> rams = new ArrayList<Ram>();
		RamDao ramDao = new RamDao();
		rams.add(ramDao.getComponent(index));
		return ramDao.deleteComponents(rams);
	}

}
