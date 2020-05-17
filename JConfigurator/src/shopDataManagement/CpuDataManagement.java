package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Cpu;

import dataSource.CpuDao;

public class CpuDataManagement extends ComponentDataManagement{
	
	
	@Override
	public ArrayList<Cpu> deleteComp(int index) throws JAXBException {
		ArrayList<Cpu> cpus = new ArrayList<Cpu>();
		CpuDao cpuDao = new CpuDao();
		cpus.add(cpuDao.readComponents().get(index));
		cpuDao.deleteComponents(cpus);
		
		return cpuDao.readComponents();
	}

	
	@Override
	public ArrayList<Cpu> addComp() throws JAXBException{
		CpuDao cpuDao = new CpuDao();
		ArrayList<Cpu> cpus = new ArrayList<Cpu>();
		
		
		String input;
		String name;
		int price;
		int power;
		String socket;
		boolean oc;
		
		Scanner parameter = new Scanner(System.in);
		System.out.println("\n\nNome: ");
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
		
		
		System.out.println("Socket: ");
		socket = parameter.nextLine();
		
		
		do {
			System.out.println("Si può fare l'overclock? ");
			System.out.println("A) Si   B) No");
			input = parameter.nextLine();
		}while(!(input.contains("a") || input.contains("b")));
		
		Cpu c;
		if(input.contains("a"))
			c = new Cpu(name, price, power, socket, true);
		else
			c = new Cpu(name, price, power, socket, false);

		cpus.add(c);
		parameter.close();
		return cpuDao.addComponents(cpus);
		
	}
}

	
