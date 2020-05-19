package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;

public class MotherboardDataManagement extends ComponentDataManagement<Motherboard>{

	ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
	public String name = null;
	public int price = 0;
	public int power = 0;
	public String socket = null;
	public String chipset = null;
	public String ramType = null;
	public int size = 0;
	public boolean oc = false;
	
	@Override
	public ArrayList<Motherboard> deleteComp(int index) throws JAXBException {
		
		MotherboardDao motherboardDao = new MotherboardDao();
		motherboards.add(motherboardDao.readComponents().get(index));
		
		return motherboardDao.deleteComponents(motherboards);
	}

	@Override
	public ArrayList<Motherboard> addComp(Scanner parameter) throws JAXBException {
		
		MotherboardDao motherboardDao = new MotherboardDao();
		String input;
		
		
		
		
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
		if(input.contains("a")) {
			oc = true;
			motherboard = new Motherboard(name, price, power, socket, chipset, ramType, oc, size);
		}
		else {
			oc = false;
			motherboard = new Motherboard(name, price, power, socket, chipset, ramType, oc, size);
		}
		motherboards.add(motherboard);
		return motherboardDao.addComponents(motherboards);
	}


	@Override
	public ArrayList<Motherboard> resetComp() throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao();
		return motherboardDao.setDefaultComponents();
	}

}
