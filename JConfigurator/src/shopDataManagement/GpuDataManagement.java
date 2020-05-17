package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuDataManagement extends ComponentDataManagement{

	private ArrayList<Gpu> gpus = new ArrayList<Gpu>();
	
	@Override
	public ArrayList<Gpu> deleteComp(int index) throws JAXBException {
		
		GpuDao gpuDao = new GpuDao();
		gpus.add(gpuDao.readComponents().get(index));
		return gpuDao.deleteComponents(gpus);
	}

	@Override
	public ArrayList<Gpu> addComp() throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		String input;
		String name;
		int price; 
		int power;
		int memory;
		
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
			System.out.println("Memoria: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		memory = Integer.parseInt(input);
		Gpu g = new Gpu(name, price, power, memory);
		
		gpus.add(g);
		parameter.close();
		
		return gpuDao.addComponents(gpus);
	}

}
