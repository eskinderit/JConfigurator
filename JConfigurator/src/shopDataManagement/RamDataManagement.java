package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import ConfiguratorEngine.Ram;
import dataSource.RamDao;

public class RamDataManagement extends ComponentDataManagement<Ram>{
	private ArrayList<Ram> rams = new ArrayList<Ram>();
	private String name = null;
	private int price = 0; 
	private int power = 0;
	private int memory = 0;
	private String ramType = null;
	
	
	


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


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	public String getRamType() {
		return ramType;
	}


	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

}
