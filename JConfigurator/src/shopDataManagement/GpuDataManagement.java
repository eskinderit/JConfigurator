package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;


import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuDataManagement extends ComponentDataManagement<Gpu>{

	private ArrayList<Gpu> gpus = new ArrayList<Gpu>();
	private String name = null;
	private int price = 0; 
	private int power = 0;
	private int memory = 0;
	
	

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

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

}
