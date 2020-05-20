package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.FullConfig;
import configuratorEngine.Motherboard;
import dataSource.MotherboardDao;

public class MotherboardAssembly extends ComponentAssembly<Motherboard> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao();
		Motherboard componentToSet = motherboardDao.getComponent(index);
		f1.setMotherboard(componentToSet);

	}

	@Override
	public ArrayList<Motherboard> getCompatibleComponents(FullConfig f1) throws JAXBException {

		MotherboardDao motherboardDao = new MotherboardDao();
		ArrayList<Motherboard> motherboardList = motherboardDao.readComponents();

		if (f1.getCpu() != null) {
			ArrayList<Motherboard> toRemoveList1 = this.getCompatibleMotherboardsByCpu(f1);
			motherboardList.retainAll(toRemoveList1);
		}

		if (f1.getCase0() != null) {
			ArrayList<Motherboard> toRemoveList2 = this.getCompatibleMotherboardsByCase(f1);
			motherboardList.retainAll(toRemoveList2);
		}

		if (f1.getRam() != null) {
			ArrayList<Motherboard> toRemoveList2 = this.getCompatibleMotherboardsByRam(f1);
			motherboardList.retainAll(toRemoveList2);
		}

		return motherboardList;
	}

	private ArrayList<Motherboard> getCompatibleMotherboardsByRam(FullConfig f1) throws JAXBException {
		MotherboardDao motherboardDao = new MotherboardDao();
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		for (Motherboard m : motherboardDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardRam(m, f1.getRam()))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}

	private ArrayList<Motherboard> getCompatibleMotherboardsByCase(FullConfig f1) throws JAXBException {
		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		MotherboardDao motherboardDao = new MotherboardDao();
		for (Motherboard m : motherboardDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardCase(m, f1.getCase0()))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}

	private ArrayList<Motherboard> getCompatibleMotherboardsByCpu(FullConfig f1) throws JAXBException {

		ArrayList<Motherboard> compatibleMotherboards = new ArrayList<Motherboard>();
		MotherboardDao motherboardDao = new MotherboardDao();
		for (Motherboard m : motherboardDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardCpu(f1.getCpu(), m))
				compatibleMotherboards.add(m);
		}
		return compatibleMotherboards;
	}

}
