package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Component;
import dataSource.CaseDao;


public class CaseDataManagement extends ComponentDataManagement{

	private ArrayList<Case> cases = new ArrayList<Case>();
	
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
		
		String name = null;
		int price = 0; 
		int power = 0;
		int size;
		
		
		
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

}
