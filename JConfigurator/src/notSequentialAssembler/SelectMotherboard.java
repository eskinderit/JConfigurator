package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class SelectMotherboard extends SelectComponent {
	private MotherboardDao motherboardDao;
	
	public SelectMotherboard() {
		motherboardDao = new MotherboardDao();
	}
	
	@Override
	public void readComponent() throws JAXBException {
		System.out.println("Select a Motherboard from list:\n");
		for(Motherboard m:motherboardDao.readComponents()) {
			System.out.println(m);
		}
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		Motherboard m = motherboardDao.readComponents().get(n);
		f.motherboard(m);
		
	}

	@Override
	public ArrayList<Motherboard> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		
		if(f.getMyCpu()!= null || f.getMyRam() != null || f.getMyCase1() != null) {
			for(Motherboard m:motherboardDao.readComponents()) {
				if(f.getMyRam() == null && f.getMyCase1() == null) {
					compatibleMotherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByCpu(f);
				}
				else if(f.getMyCpu() == null && f.getMyCase1() == null) {
					compatibleMotherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByRam(f);
				}
				else if(f.getMyCpu() == null && f.getMyRam() == null) {
					compatibleMotherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByCase(f);
				}
				else if(f.getMyCase1() == null && f.getMyCpu() != null && f.getMyRam()!= null) {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getRamType().contentEquals(f.getMyRam().getRamType()))
						compatibleMotherboards.add(m);
				}
				else if(f.getMyRam() == null && f.getMyCpu() != null && f.getMyCase1() != null) {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getSize()<=f.getMyCase1().getSize())
						compatibleMotherboards.add(m);
				}
				else if(f.getMyCpu() == null && f.getMyRam() != null && f.getMyCase1() != null) {
					if(m.getRamType().contentEquals(f.getMyRam().getRamType()) && m.getSize()<=f.getMyCase1().getSize())
						compatibleMotherboards.add(m);
				}
				else {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getRamType().contentEquals(f.getMyRam().getRamType()) && m.getSize()<=f.getMyCase1().getSize()) {
						compatibleMotherboards.add(m);
					}
				}
					
			}
		}
		else 
			compatibleMotherboards = motherboardDao.readComponents();
		
		System.out.println("Select motherboard from list: ");
		for(Motherboard m : compatibleMotherboards) {
			System.out.println(m);
		}
		return compatibleMotherboards;

	}
	
	
}
