package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;
import dataSource.MotherboardDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class MotherboardSelection implements ComponentSelection{
	private MotherboardDao motherboardList;
	private int size;

	public MotherboardSelection() throws JAXBException {
		motherboardList = new MotherboardDao();
		size = motherboardList.readComponents().size();
	}


	@Override
	public ArrayList<Motherboard> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Motherboard> motherboards = new ArrayList<Motherboard>();

		if(f.getMyCpu()!= null || f.getMyRam() != null || f.getMyCase1() != null) {
			for(Motherboard m:motherboardList.readComponents()) {
				if(f.getMyRam() == null && f.getMyCase1() == null) {
					motherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByCpu(f);
				}
				else if(f.getMyCpu() == null && f.getMyCase1() == null) {
					motherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByRam(f);
				}
				else if(f.getMyCpu() == null && f.getMyRam() == null) {
					motherboards = CompatibilityCheckAlgs.getCompatibleMotherboardsByCase(f);
				}
				else if(f.getMyCase1() == null && f.getMyCpu() != null && f.getMyRam()!= null) {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getRamType().contentEquals(f.getMyRam().getRamType()))
						motherboards.add(m);
				}
				else if(f.getMyRam() == null && f.getMyCpu() != null && f.getMyCase1() != null) {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getSize()<=f.getMyCase1().getSize())
						motherboards.add(m);
				}
				else if(f.getMyCpu() == null && f.getMyRam() != null && f.getMyCase1() != null) {
					if(m.getRamType().contentEquals(f.getMyRam().getRamType()) && m.getSize()<=f.getMyCase1().getSize())
						motherboards.add(m);
				}
				else {
					if(m.getSocket().contentEquals(f.getMyCpu().getSocket()) && m.getRamType().contentEquals(f.getMyRam().getRamType()) && m.getSize()<=f.getMyCase1().getSize()) {
						motherboards.add(m);
					}
				}

			}
			
		}
		else 
			motherboards = motherboardList.readComponents();


		size = motherboards.size();
		
		return motherboards;

	}


	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}
