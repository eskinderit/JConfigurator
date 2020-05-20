package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.Ram;
import dataSource.ComponentDao;
import dataSource.RamDao;

public class RamAssembly extends ComponentAssembly<Ram> {

	@Override
	public ComponentAssembly<?> getPreviousPassage() {
		return new MotherboardAssembly();
	}

	@Override
	public ComponentAssembly<?> getNextPassage() {
		return new CaseAssembly();
	}

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		RamDao ramDao = new RamDao();
		Ram componentToSet = ramDao.getComponent(index);
		f1.setRam(componentToSet);
	}

	@Override
	public ComponentDao<Ram, RamDao> getComponentDao() {
		return new RamDao();
	}

	@Override
	public ArrayList<Ram> getCompatibleComponents(FullConfig f1) throws JAXBException {
		if (f1.getMotherboard() != null)
			return this.getCompatibleRamsByMotherboard(f1);
		else {
			RamDao ramDao = new RamDao();
			return ramDao.readComponents();
		}

	}

	private ArrayList<Ram> getCompatibleRamsByMotherboard(FullConfig f1) throws JAXBException {
		RamDao ramDao = new RamDao();
		ArrayList<Ram> compatibleRams = new ArrayList<Ram>();
		for (Ram r : ramDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkMotherboardRam(f1.getMotherboard(), r))
				compatibleRams.add(r);
		}
		return compatibleRams;
	}

}
