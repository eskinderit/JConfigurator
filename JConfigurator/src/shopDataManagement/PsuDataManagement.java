package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Psu;
import dataSource.PsuDao;

public class PsuDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Psu> deleteComp(int index) throws JAXBException {
		ArrayList<Psu> psuList = new ArrayList<Psu>();
		PsuDao psuDao = new PsuDao();
		psuList.add(psuDao.getComponent(index));
		return psuDao.deleteComponents(psuList);
	}

}
