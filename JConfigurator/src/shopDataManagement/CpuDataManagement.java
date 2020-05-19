package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import ConfiguratorEngine.Cpu;

import dataSource.CpuDao;

public class CpuDataManagement extends ComponentDataManagement<Cpu>{
	ArrayList<Cpu> cpus = new ArrayList<Cpu>();
	public String name = null;
	public int price = 0;
	public int power = 0;
	public String socket = null;
	public boolean oc = false;
	
	@Override
	public ArrayList<Cpu> deleteComp(int index) throws JAXBException {
		
		CpuDao cpuDao = new CpuDao();
		cpus.add(cpuDao.readComponents().get(index));
		cpuDao.deleteComponents(cpus);
		
		return cpuDao.readComponents();
	}

	
	@Override
	public ArrayList<Cpu> addComp(Scanner parameter) throws JAXBException{
		CpuDao cpuDao = new CpuDao();
		
		
		String input;
		
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
		System.out.println("Socket: ");
		socket = parameter.nextLine();
		
		
		do {
			System.out.println("Si può fare l'overclock? ");
			System.out.println("A) Si   B) No");
			input = parameter.nextLine();
		}while(!(input.contains("a") || input.contains("b")));
		
		Cpu c;
		if(input.contains("a")) {
			oc=true;
			c = new Cpu(name, price, power, socket, oc);
		}
		else {
			oc = false;
			c = new Cpu(name, price, power, socket, oc);
		}

		cpus.add(c);
		return cpuDao.addComponents(cpus);
		
	}


	@Override
	public ArrayList<Cpu> resetComp() throws JAXBException {
		CpuDao cpuDao = new CpuDao();
		return cpuDao.setDefaultComponents();
	}
}

	
