package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import configuratorEngine.FullConfig;
import configuratorEngine.Psu;
import dataSource.PsuDao;

public class PsuAssembly extends ComponentAssembly<Psu> {

	@Override
	protected void passageBehavior(FullConfig f1, int index) throws JAXBException {
		PsuDao psuDao = new PsuDao();
		Psu componentToSet = psuDao.getComponent(index);
		f1.setPsu(componentToSet);
	}

	@Override
	public ArrayList<Psu> getCompatibleComponents(FullConfig f1) throws JAXBException {

		if ((f1.getCpu() != null) && (f1.getGpu() != null) && (f1.getMotherboard() != null) && (f1.getRam() != null)
				&& (f1.getCase0() != null) && (f1.getStorage() != null)) {
			return this.getCompatiblePsu(f1);
		} else
			return null;

	}

	private ArrayList<Psu> getCompatiblePsu(FullConfig f1) throws JAXBException {
		ArrayList<Psu> compatiblePsus = new ArrayList<Psu>();
		PsuDao psuDao = new PsuDao();
		for (Psu p : psuDao.readComponents()) {
			if (CompatibilityCheckAlgs.checkTotalWattagePsu(f1, p))
				compatiblePsus.add(p);
		}
		return compatiblePsus;
	}

}
