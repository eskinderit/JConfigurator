package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Case;
import dataSource.CaseDao;
import dataSource.ComponentDao;


public class CaseDataManagement extends ComponentDataManagement<Case>{

	private CaseDao caseDao = new CaseDao();
	private ArrayList<Case> cases = new ArrayList<Case>();
	
	private int size = 0;
	
	@Override
	public ArrayList<Case> deleteComp(int index) throws JAXBException {

		cases.add(caseDao.readComponents().get(index));
		return caseDao.deleteComponents(cases);
	}

	@Override
	public ArrayList<Case> addComp(Scanner parameter) throws JAXBException {

		String input;

		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		

		do {
			System.out.println("Dimensione: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		size = Integer.parseInt(input);

		Case case1 = new Case(getName(), getPrice(), getPower(), size);

		cases.add(case1);

		return caseDao.addComponents(cases);
	}


	@Override
	public ArrayList<Case> resetComp() throws JAXBException {
		return caseDao.setDefaultComponents();
	}
	
	
	/**
	 * Getters and setters of remaining Case parameters (size)
	 */
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public ComponentDao<Case, ?> getComponentDao() {
		return caseDao;
	}

}
