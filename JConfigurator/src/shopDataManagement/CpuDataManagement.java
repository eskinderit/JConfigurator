package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import configuratorEngine.Cpu;
import dataSource.ComponentDao;
import dataSource.CpuDao;

public class CpuDataManagement extends ComponentDataManagement<Cpu>{
	
	CpuDao cpuDao = new CpuDao();
	
	ArrayList<Cpu> cpus = new ArrayList<Cpu>();
	private String socket = null;
	private boolean oc = false;
	
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
		
		
		this.setName(parameter);
		this.setPrice(parameter);
		this.setPower(parameter);
		
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
			c = new Cpu(getName(), getPrice(), getPower(), socket, oc);
		}
		else {
			oc = false;
			c = new Cpu(getName(), getPrice(), getPower(), socket, oc);
		}

		cpus.add(c);
		return cpuDao.addComponents(cpus);
		
	}


	@Override
	public ArrayList<Cpu> resetComp() throws JAXBException {
		CpuDao cpuDao = new CpuDao();
		return cpuDao.setDefaultComponents();
	}
	
	
	/**
	 * Getters and setters of remaining Cpu parameters (Socket, oc)
	 */
	
	public String getSocket() {
		return socket;
	}


	public void setSocket(String socket) {
		this.socket = socket;
	}


	public boolean isOc() {
		return oc;
	}


	public void setOc(boolean oc) {
		this.oc = oc;
	}


	@Override
	public ComponentDao<Cpu, ?> getComponentDao() {
		return cpuDao;
	}
}

	
