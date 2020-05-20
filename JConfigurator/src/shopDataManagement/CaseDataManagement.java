package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Case;
import dataSource.CaseDao;


public class CaseDataManagement extends ComponentDataManagement<Case>{

	private ArrayList<Case> cases = new ArrayList<Case>();
	private String name = null;
	private int price = 0; 
	private int power = 0;
	private int size = 0;
	
	@Override
	public ArrayList<Case> deleteComp(int index) throws JAXBException {

		CaseDao caseDao = new CaseDao();
		cases.add(caseDao.readComponents().get(index));
		return caseDao.deleteComponents(cases);
	}

	@Override
	public ArrayList<Case> addComp(Scanner parameter) throws JAXBException {

		String input;
		CaseDao caseDao = new CaseDao();

		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);

		do {
			System.out.println("Dimensione: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		size = Integer.parseInt(input);

		Case case1 = new Case(name, price, power, size);

		cases.add(case1);

		return caseDao.addComponents(cases);
	}


	@Override
	public ArrayList<Case> resetComp() throws JAXBException {
		CaseDao caseDao = new CaseDao();
		return caseDao.setDefaultComponents();
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
