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
	public ArrayList<Ram> addComp() throws JAXBException {
		RamDao ramDao = new RamDao();
		String input;
		String name;
		int price; 
		int power;
		int memory;
		String ramType;
		
		Scanner parameter = new Scanner(System.in);
		System.out.println("Nome: ");
		name = parameter.nextLine();
		
		do {
			System.out.println("Prezzo: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		price = Integer.parseInt(input);
		
		do {
			System.out.println("Potenza: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		power = Integer.parseInt(input);
		
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

}
