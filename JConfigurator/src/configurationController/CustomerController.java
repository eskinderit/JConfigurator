package configurationController;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.*;
import dataSource.*;


public class CustomerController {
	private FullConfig fullConfig;
	private ComputerShop computerShop;

	
//TODO change constructors to possibly include computershop
	
	public ComputerShop getComputerShop() {
		return computerShop;
	}

	public void setComputerShop(ComputerShop computerShop) {
		this.computerShop = computerShop;
	}

	public CustomerController(FullConfig fullConfig) {
		super();
		this.fullConfig = fullConfig;
	}
	
	public CustomerController() {
		this.fullConfig=FullConfig.getIstance();
		this.computerShop = new ComputerShop();
	}

	public FullConfig getFullConfig() {
		return fullConfig;
	}

	public void setFullConfig(FullConfig fullConfig) {
		this.fullConfig = fullConfig;
	}
	
	public ArrayList<Motherboard> getCompatibleMotherboard(MotherboardDao motherboardDao) throws JAXBException{
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		for(Motherboard m:motherboardDao.readComponents()) {
			if(FullConfig.checkMotherboardCpu(this.fullConfig.getMyCpu(),m))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}
	
	public ArrayList<Ram> getCompatibleRam(RamDao ramDao) throws JAXBException{
		ArrayList<Ram> compatibleRams = new ArrayList<Ram>();
		for(Ram r:ramDao.readComponents()) {
			if(FullConfig.checkMotherboardRam(this.fullConfig.getMyMotherboard(),r))
				compatibleRams.add(r);
		}
		return compatibleRams;
	}
	
	public ArrayList<Case> getCompatibleCase(CaseDao caseDao) throws JAXBException{
		ArrayList<Case> compatibleCases = new ArrayList<Case>();
		for(Case c:caseDao.readComponents()) {
			if(FullConfig.checkMotherboardCase(this.fullConfig.getMyMotherboard(),c))
				compatibleCases.add(c);
		}
		return compatibleCases;
	}
	
	public int getTotalPrice() {
		return this.fullConfig.getTotalPrice();
		
	}
	
	public int getTotalPowerOverstimation() {
		return this.fullConfig.getTotalEstimatedPower()+this.fullConfig.getPsuOverhead();
	}
	

	public ArrayList<Psu> getCompatiblePsu(PsuDao psuDao) throws JAXBException{
		ArrayList<Psu> compatiblePsus = new ArrayList<Psu>();
		for(Psu p:psuDao.readComponents()) {
			if(FullConfig.checkTotalWattagePsu(this.fullConfig,p))
				compatiblePsus.add(p);
		}
		return compatiblePsus;
	}
	


}
