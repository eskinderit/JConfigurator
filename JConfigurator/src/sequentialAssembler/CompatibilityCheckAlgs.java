package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.*;
import dataSource.*;


public class CompatibilityCheckAlgs {


	static	public int getTotalPowerOverstimation(FullConfig f1) {
		return f1.getTotalEstimatedPower() + f1.getPsuOverhead();
	}
	
	static	public int getTotalPrice (FullConfig f1) {
		return f1.getTotalPrice();
	}

	static	public ArrayList<Motherboard> getCompatibleMotherboardsByCpu(FullConfig f1) throws JAXBException{

		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		MotherboardDao motherboardDao = new MotherboardDao();
		for(Motherboard m:motherboardDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardCpu(f1.getMyCpu(),m))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}
	
	static	public ArrayList<Cpu> getCompatibleCpusByMotherboard(FullConfig f1) throws JAXBException{

		ArrayList<Cpu> compatibleCpus = new ArrayList<Cpu>();
		CpuDao cpuDao = new CpuDao();
		for(Cpu c : cpuDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardCpu(c, f1.getMyMotherboard()))
				compatibleCpus.add(c);
		}
		return compatibleCpus;
	}

	static public ArrayList<Ram> getCompatibleRamsByMotherboard(FullConfig f1) throws JAXBException{
		RamDao ramDao = new RamDao();
		ArrayList<Ram> compatibleRams = new ArrayList<Ram>();
		for(Ram r:ramDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardRam(f1.getMyMotherboard(),r))
				compatibleRams.add(r);
		}
		return compatibleRams;
	}
	
	static public ArrayList<Motherboard> getCompatibleMotherboardsByRam(FullConfig f1) throws JAXBException{
		MotherboardDao motherboardDao = new MotherboardDao();
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		for(Motherboard m:motherboardDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardRam(m ,f1.getMyRam()))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}

	static public ArrayList<Case> getCompatibleCasesByMotherboard(FullConfig f1) throws JAXBException{
		ArrayList<Case> compatibleCases = new ArrayList<Case>();
		CaseDao caseDao = new CaseDao();
		for(Case c:caseDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardCase(f1.getMyMotherboard(),c))
				compatibleCases.add(c);
		}
		return compatibleCases;
	}
	
	static public ArrayList<Motherboard> getCompatibleMotherboardsByCase(FullConfig f1) throws JAXBException{
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		MotherboardDao motherboardDao = new MotherboardDao();
		for(Motherboard m : motherboardDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkMotherboardCase(m,f1.getMyCase1()))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}



	static public ArrayList<Psu> getCompatiblePsu(FullConfig f1) throws JAXBException{
		ArrayList<Psu> compatiblePsus = new ArrayList<Psu>();
		PsuDao psuDao = new PsuDao();
		for(Psu p:psuDao.readComponents()) {
			if(CompatibilityCheckAlgs.checkTotalWattagePsu(f1,p))
				compatiblePsus.add(p);
		}
		return compatiblePsus;
	}


	static public boolean checkTotalWattagePsu(FullConfig f1, Psu psu ) {
		if(psu.getPower()-f1.getTotalEstimatedPower()>50)
			return true;
		else
			return false;
	}

	static public boolean checkMotherboardCase(Motherboard m1, Case c1) {
		if( c1.getSize()>=m1.getSize())
			return true;
		else
			return false;
	}

	static public boolean checkMotherboardRam(Motherboard m1, Ram r1) {
		if(r1.getRamType().contentEquals(m1.getRamType()))
			return true;
		else
			return false;
	}

	static public boolean checkMotherboardCpu(Cpu c1, Motherboard m1) {
		if(m1.getSocket().contentEquals(c1.getSocket()))
			return true;
		else
			return false;
	}



}
