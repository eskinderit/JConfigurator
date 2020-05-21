package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import configuratorEngine.Ram;
import dataSource.ComponentDao;
import dataSource.RamDao;

public class RamDataManagement extends ComponentDataManagement<Ram>{
	RamDao ramDao = new RamDao();
	private ArrayList<Ram> rams = new ArrayList<Ram>();
	private int memory = 0;
	private String ramType = null;
	
	
	


	@Override
	public ArrayList<Ram> deleteComp(int index) throws JAXBException {
		
		rams.add(ramDao.getComponent(index));
		return ramDao.deleteComponents(rams);
	}

	
	@Override
	public ArrayList<Ram> addComp(Scanner parameter) throws JAXBException {
		String input;
		
		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		
		do {
			System.out.println("Memoria: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		memory = Integer.parseInt(input);
		
		System.out.println("Ram Type: ");
		ramType = parameter.nextLine();
		
		Ram ram = new Ram(getName(), getPrice(), getPower(), ramType, memory);
		
		rams.add(ram);
		return ramDao.addComponents(rams);
	}

	@Override
	public ArrayList<Ram> resetComp() throws JAXBException {
		return ramDao.setDefaultComponents();
	}
	
	
	
	/**
	 * Getters and setters of remaining Ram parameters (memory, ramType)
	 */
	

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


	@Override
	public ComponentDao<Ram, ?> getComponentDao() {
		return ramDao;
	}

}
