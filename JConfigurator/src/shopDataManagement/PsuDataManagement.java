package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import configuratorEngine.Psu;
import dataSource.PsuDao;


public class PsuDataManagement extends ComponentDataManagement<Psu>{

	private ArrayList<Psu> psus= new ArrayList<Psu>();
	private String name = null;
	private int price = 0; 
	private int power = 0;
	
	

	@Override
	public ArrayList<Psu> deleteComp(int index) throws JAXBException {
		
		PsuDao psuDao = new PsuDao();
		psus.add(psuDao.getComponent(index));
		return psuDao.deleteComponents(psus);
	}

	@Override
	public ArrayList<Psu> addComp(Scanner parameter) throws JAXBException {

		PsuDao psuDao = new PsuDao();
		
		
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
		Psu psu1 = new Psu(name, price, power);
		
		psus.add(psu1);
		
		return psuDao.addComponents(psus);
	}

	@Override
	public ArrayList<Psu> resetComp() throws JAXBException {
		PsuDao psuDao = new PsuDao();
		return psuDao.setDefaultComponents();
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
	

}
