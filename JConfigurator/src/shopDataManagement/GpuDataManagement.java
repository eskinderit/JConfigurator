package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;


import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuDataManagement extends ComponentDataManagement<Gpu>{

	private ArrayList<Gpu> gpus = new ArrayList<Gpu>();
	
	@Override
	public ArrayList<Gpu> deleteComp(int index) throws JAXBException {
		
		GpuDao gpuDao = new GpuDao();
		gpus.add(gpuDao.readComponents().get(index));
		return gpuDao.deleteComponents(gpus);
	}

	@Override
	public ArrayList<Gpu> addComp(Scanner parameter) throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		String input;
		String name = null;
		int price = 0; 
		int power = 0;
		int memory;
		
		name = this.setName(parameter, name);
		price = this.setPrice(parameter, price);
		power = this.setPower(parameter, power);
		
		do {
			System.out.println("Memoria: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		memory = Integer.parseInt(input);
		Gpu g = new Gpu(name, price, power, memory);
		
		gpus.add(g);
		
		return gpuDao.addComponents(gpus);
	}


	@Override
	public ArrayList<Gpu> resetComp() throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		return gpuDao.setDefaultComponents();
	}

}
