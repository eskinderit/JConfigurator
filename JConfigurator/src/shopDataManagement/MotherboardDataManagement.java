package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;

public class MotherboardDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Motherboard> deleteComp(int index) throws JAXBException {
		ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
		MotherboardDao motherboardDao = new MotherboardDao();
		motherboards.add(motherboardDao.readComponents().get(index));
		
		return motherboardDao.deleteComponents(motherboards);
	}

}
