package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import configuratorEngine.Motherboard;
import dataSource.ComponentDao;
import dataSource.MotherboardDao;

public class MotherboardDataManagement extends ComponentDataManagement<Motherboard>{
	
	private MotherboardDao motherboardDao = new MotherboardDao();
	
	ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();
	private String socket = null;
	private String chipset = null;
	private String ramType = null;
	private int size = 0;
	private boolean oc = false;
	
	
	
	

	@Override
	public ArrayList<Motherboard> deleteComp(int index) throws JAXBException {
		
		motherboards.add(motherboardDao.readComponents().get(index));
		
		return motherboardDao.deleteComponents(motherboards);
	}

	@Override
	public ArrayList<Motherboard> addComp(Scanner parameter) throws JAXBException {
		
		String input;
		
		
		
		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
			
		
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
			motherboard = new Motherboard(getName(), getPrice(), getPower(), socket, chipset, ramType, oc, size);
		}
		else {
			oc = false;
			motherboard = new Motherboard(getName(), getPrice(), getPower(), socket, chipset, ramType, oc, size);
		}
		motherboards.add(motherboard);
		return motherboardDao.addComponents(motherboards);
	}


	@Override
	public ArrayList<Motherboard> resetComp() throws JAXBException {

		return motherboardDao.setDefaultComponents();
	}
	
	
	/**
	 * Getters and setters of remaining Motherboard parameters (socket, chipset, ramType, size, oc)
	 */

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

	@Override
	public ComponentDao<Motherboard, ?> getComponentDao() {
		return motherboardDao;
	}

}
