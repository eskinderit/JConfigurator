package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;

import dataSource.CaseDao;
import dataSource.ComponentDao;
import dataSource.CpuDao;
import dataSource.GpuDao;
import dataSource.MotherboardDao;
import dataSource.PsuDao;
import dataSource.RamDao;
import dataSource.StorageDao;

public abstract class ComponentDataManagement<T extends Component> {
	
	public static ComponentDao<?, ?> ComponentData(String c) throws JAXBException {
		
		if(c.contains("a")) {
			ComponentDao<?, ?> cpus = new CpuDao();
			return cpus;
		}
		else if(c.contains("b")) {
			GpuDao gpus = new GpuDao();
			return gpus;
		}
		else if(c.contains("c")){
			MotherboardDao motherboards = new MotherboardDao();
			return motherboards;
		}
		else if(c.contains("d")){
			CaseDao cases = new CaseDao();
			return cases;
		}
		else if(c.contains("e")){
			RamDao rams = new RamDao();
			return rams;
		}
		else if(c.contains("f")){
			StorageDao storages = new StorageDao();
			return storages;
		}
		else {
			PsuDao psus = new PsuDao();
			return psus;
		}
	}
	
	protected String setName (Scanner parameter, String name) {

		System.out.println("Nome: ");
		name = parameter.nextLine();
		return name;
	}
	
	protected int setPrice (Scanner parameter, int price) {
		String input;
		do {
			System.out.println("Prezzo: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		price = Integer.parseInt(input);
		return price;
	}
	
	protected int setPower(Scanner parameter, int power) {
		String input;
		do {
			System.out.println("Potenza: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		power = Integer.parseInt(input);
		return power;
	}
	
	abstract public  ArrayList<T> deleteComp (int index) throws JAXBException;
	
	abstract public  ArrayList<T> addComp (Scanner parameter) throws JAXBException;
	
	abstract public  ArrayList<T> resetComp() throws JAXBException;
	
}
