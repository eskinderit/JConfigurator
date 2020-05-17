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
	public ArrayList<Case> addComp() throws JAXBException {
		
		String input;
		CaseDao caseDao = new CaseDao();
		
		String name;
		int price; 
		int power;
		int size;
		
		Scanner parameter = new Scanner(System.in);
		System.out.println("Nome: ");
		name = parameter.nextLine();
		
		do {
			System.out.println("Prezzo: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		price = Integer.parseInt(input);
		
		do {
			System.out.println("Potenza: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		power = Integer.parseInt(input);
		
		do {
			System.out.println("Dimensione: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		size = Integer.parseInt(input);
		
		Case case1 = new Case(name, price, power, size);
		
		cases.add(case1);
		
		
		return caseDao.addComponents(cases);
	}

}
