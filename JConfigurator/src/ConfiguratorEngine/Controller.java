package ConfiguratorEngine;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import dataSource.CaseDao;
import dataSource.MotherboardDao;
import dataSource.PsuDao;
import dataSource.RamDao;

public class Controller {
	private FullConfig fullConfig;

	public Controller(FullConfig fullConfig) {
		super();
		this.fullConfig = fullConfig;
	}

	public Controller() {
		this.fullConfig=new FullConfig();
	}

	public FullConfig getFullConfig() {
		return fullConfig;
	}

	public void setFullConfig(FullConfig fullConfig) {
		this.fullConfig = fullConfig;
	}
	
	public ArrayList<Motherboard> checkMotherboard(MotherboardDao motherboardDao) throws JAXBException{
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		for(Motherboard m:motherboardDao.readComponents()) {
			if(m.getSocket().contentEquals(fullConfig.getMyCpu().getSocket()))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}
	
	public ArrayList<Ram> checkRam(RamDao ramDao) throws JAXBException{
		ArrayList<Ram> compatibleRams = new ArrayList<Ram>();
		for(Ram r:ramDao.readComponents()) {
			if(r.getRamType().contentEquals(fullConfig.getMyMotherboard().getRamType()))
				compatibleRams.add(r);
		}
		return compatibleRams;
	}
	
	public ArrayList<Case> checkCase(CaseDao caseDao) throws JAXBException{
		ArrayList<Case> compatibleCases = new ArrayList<Case>();
		for(Case c:caseDao.readComponents()) {
			if(c.getSize()==fullConfig.getMyMotherboard().getSize())
				compatibleCases.add(c);
		}
		return compatibleCases;
	}
	
	public int totalPower() {
		int allPower=0;
		allPower+=fullConfig.getMyCpu().getPower();
		allPower+=fullConfig.getMyGpu().getPower();
		allPower+=fullConfig.getMyMotherboard().getPower();
		allPower+=fullConfig.getMyRam().getPower();
		allPower+=fullConfig.getMyCase1().getPower();
		allPower+=fullConfig.getMyStorage().getPower();
		fullConfig.setTotalPower(allPower);
		return allPower;
	}
	
	public ArrayList<Psu> checkPsu(PsuDao psuDao) throws JAXBException{
		ArrayList<Psu> compatiblePsus = new ArrayList<Psu>();
		for(Psu p:psuDao.readComponents()) {
			if(p.getPower()-fullConfig.getTotalPower()>50)
				compatiblePsus.add(p);
		}
		return compatiblePsus;
	}
	

}
