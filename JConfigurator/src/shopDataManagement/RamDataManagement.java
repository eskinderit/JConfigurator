package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;

public class RamDataManagement extends ComponentDataManagement{
	private ArrayList<Ram> rams = new ArrayList<Ram>();
	
	@Override
	public ArrayList<Ram> deleteComp(int index) throws JAXBException {
		
		RamDao ramDao = new RamDao();
		rams.add(ramDao.getComponent(index));
		return ramDao.deleteComponents(rams);
	}

	
	@Override
	public ArrayList<Ram> addComp(Scanner parameter) throws JAXBException {
		RamDao ramDao = new RamDao();
		String input;
		String name = null;
		int price = 0; 
		int power = 0;
		int memory;
		String ramType;
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
		do {
			System.out.println("Memoria: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		memory = Integer.parseInt(input);
		
		System.out.println("Ram Type: ");
		ramType = parameter.nextLine();
		
		Ram ram = new Ram(name, price, power, ramType, memory);
		
		rams.add(ram);
		return ramDao.addComponents(rams);
	}

	@Override
	public ArrayList<Ram> resetComp() throws JAXBException {
		RamDao ramDao = new RamDao();
		return ramDao.setDefaultComponents();
	}

}
