package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Motherboard;
import dataSource.MotherboardDao;

public class MotherboardDataManagement extends ComponentDataManagement<Motherboard>{

	ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
	private String name = null;
	private int price = 0;
	private int power = 0;
	private String socket = null;
	private String chipset = null;
	private String ramType = null;
	private int size = 0;
	private boolean oc = false;
	
	
	
	

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
	
	
	// GETTERS AND SETTERS
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isOc() {
		return oc;
	}

	public void setOc(boolean oc) {
		this.oc = oc;
	}

}
