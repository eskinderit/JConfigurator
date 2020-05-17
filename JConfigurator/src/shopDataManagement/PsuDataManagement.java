package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Psu;
import dataSource.PsuDao;


public class PsuDataManagement extends ComponentDataManagement{

	private ArrayList<Psu> psus= new ArrayList<Psu>();
	
	@Override
	public ArrayList<Psu> deleteComp(int index) throws JAXBException {
		
		PsuDao psuDao = new PsuDao();
		psus.add(psuDao.getComponent(index));
		return psuDao.deleteComponents(psus);
	}

	@Override
	public ArrayList<Psu> addComp() throws JAXBException {

		PsuDao psuDao = new PsuDao();
		
		String name = null;
		int price = 0; 
		int power = 0;
		
		Scanner parameter = new Scanner(System.in);
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
		Psu psu1 = new Psu(name, price, power);
		
		psus.add(psu1);
		parameter.close();
		
		return psuDao.addComponents(psus);
	}

	@Override
	public ArrayList<Psu> resetComp() throws JAXBException {
		PsuDao psuDao = new PsuDao();
		return psuDao.setDefaultComponents();
	}
	

}
