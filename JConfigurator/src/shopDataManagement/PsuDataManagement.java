package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import configuratorEngine.Psu;
import dataSource.ComponentDao;
import dataSource.PsuDao;


public class PsuDataManagement extends ComponentDataManagement<Psu>{

	PsuDao psuDao = new PsuDao();
	private ArrayList<Psu> psus= new ArrayList<Psu>();

	@Override
	public ArrayList<Psu> deleteComp(int index) throws JAXBException {
		
		psus.add(psuDao.getComponent(index));
		return psuDao.deleteComponents(psus);
	}

	@Override
	public ArrayList<Psu> addComp(Scanner parameter) throws JAXBException {

		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		
		Psu psu1 = new Psu(getName(), getPrice(), getPower());
		
		psus.add(psu1);
		
		return psuDao.addComponents(psus);
	}

	@Override
	public ArrayList<Psu> resetComp() throws JAXBException {
		return psuDao.setDefaultComponents();
	}

	@Override
	public ComponentDao<Psu, ?> getComponentDao() {
		return psuDao;
	}

}
