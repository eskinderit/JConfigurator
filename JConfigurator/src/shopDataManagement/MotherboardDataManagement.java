package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;

public class MotherboardDataManagement extends ComponentDataManagement{

	ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
	
	@Override
	public ArrayList<Motherboard> deleteComp(int index) throws JAXBException {
		
		MotherboardDao motherboardDao = new MotherboardDao();
		motherboards.add(motherboardDao.readComponents().get(index));
		
		return motherboardDao.deleteComponents(motherboards);
	}

	@Override
	public ArrayList<Motherboard> addComp() throws JAXBException {
		
		MotherboardDao motherboardDao = new MotherboardDao();
		String input;
		
		String name = null;
		int price = 0;
		int power = 0;
		String socket;
		String chipset;
		String ramType;
		int size;
		
		Scanner parameter = new Scanner(System.in);
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
			
		
		System.out.println("Socket: ");
		socket = parameter.nextLine();
		
		System.out.println("Chipset: ");
		chipset = parameter.nextLine();
		
		System.out.println("RamType: ");
		ramType = parameter.nextLine();
		
		do {
			System.out.println("Dimensione: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		size = Integer.parseInt(input);
		
		do {
			System.out.println("Permette l'overclock? ");
			System.out.println("A) Si   B) No");
			input = parameter.nextLine();
		}while(!(input.contains("a") || input.contains("b")));
		
		
		Motherboard motherboard;
		if(input.contains("a"))
			motherboard = new Motherboard(name, price, power, socket, chipset, ramType, true, size);
		else
			motherboard = new Motherboard(name, price, power, socket, chipset, ramType, false, size);
		
		motherboards.add(motherboard);
		parameter.close();
		return motherboardDao.addComponents(motherboards);
	}


	@Override
	public ArrayList<Motherboard> resetComp() throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao();
		return motherboardDao.setDefaultComponents();
	}

}
