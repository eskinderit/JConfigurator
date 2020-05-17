package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

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
		String input;
		PsuDao psuDao = new PsuDao();
		
		String name;
		int price; 
		int power;
		int size;
		
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
		
		
		Psu psu1 = new Psu(name, price, power);
		
		psus.add(psu1);
		
		
		return psuDao.addComponents(psus);
	}
	

}
