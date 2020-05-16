package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;
import dataSource.ComponentDao;
import dataSource.MotherboardDao;


public class MotherboardAssembly extends ComponentAssembly {

	@Override
public	ComponentAssembly getPreviousPassage() {
		return new GpuAssembly();
	}
	
	@Override
public	ComponentAssembly getNextPassage() {
		return new RamAssembly();
	}

	@Override
	protected void setComponentByIndex(FullConfigBuilder f1, int index) throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao(); 
		Motherboard componentToSet = motherboardDao.getComponent(index);
		f1.setMotherboard(componentToSet);
		
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new MotherboardDao();
	}

	@Override
	public ArrayList<Motherboard> getCompatibleComponents(FullConfigBuilder f1) throws JAXBException {

		MotherboardDao motherboardDao = new MotherboardDao();
		ArrayList<Motherboard> motherboardList = motherboardDao.readComponents();
		
		
		if (f1.getMyCpu()!=null) {
			ArrayList<Motherboard> toRemoveList1 = CompatibilityCheckAlgs.getCompatibleMotherboardsByCpu(f1);
			motherboardList.retainAll(toRemoveList1);
		}
			
		if (f1.getMyCase1()!=null) {
			ArrayList<Motherboard> toRemoveList2 = CompatibilityCheckAlgs.getCompatibleMotherboardsByCase(f1);
			motherboardList.retainAll(toRemoveList2);
		}
			
		if (f1.getMyRam()!=null) {
			ArrayList<Motherboard> toRemoveList2 = CompatibilityCheckAlgs.getCompatibleMotherboardsByRam(f1);
			motherboardList.retainAll(toRemoveList2);
		}
		
		
		return motherboardList;
	}
	


}
