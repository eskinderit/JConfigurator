package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.FullConfig;
import configuratorEngine.Ram;
import dataSource.RamDao;

public class RamAssembly extends ComponentAssembly<Ram> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		RamDao ramDao = new RamDao();
		Ram componentToSet = ramDao.getComponent(index);
		f1.setRam(componentToSet);
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
