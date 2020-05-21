package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;


import configuratorEngine.Gpu;
import dataSource.ComponentDao;
import dataSource.GpuDao;

public class GpuDataManagement extends ComponentDataManagement<Gpu>{

	private GpuDao gpuDao = new GpuDao();
	private ArrayList<Gpu> gpus = new ArrayList<Gpu>();
	private int memory = 0;
	
	

	@Override
	public ArrayList<Gpu> deleteComp(int index) throws JAXBException {
		
		gpus.add(gpuDao.readComponents().get(index));
		return gpuDao.deleteComponents(gpus);
	}

	@Override
	public ArrayList<Gpu> addComp(Scanner parameter) throws JAXBException {
		String input;
		
		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		
		do {
			System.out.println("Memoria: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		memory = Integer.parseInt(input);
		Gpu g = new Gpu(getName(), getPrice(), getPower(), memory);
		
		gpus.add(g);
		
		return gpuDao.addComponents(gpus);
	}


	@Override
	public ArrayList<Gpu> resetComp() throws JAXBException {
		return gpuDao.setDefaultComponents();
	}
	
	
	/**
	 * Getters and setters of remaining Gpu parameters (memory)
	 * @return
	 */


	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public ComponentDao<Gpu, ?> getComponentDao() {
		return gpuDao;
	}

}
