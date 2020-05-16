package sequentialAssembler;


import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Ram;
import dataSource.ComponentDao;
import dataSource.RamDao;

public class RamAssembly extends ComponentAssembly {

	@Override
	public	ComponentAssembly getPreviousPassage() {
		return new MotherboardAssembly();
	}

	@Override
	public	ComponentAssembly getNextPassage() {
		return new CaseAssembly();
	}

	@Override
	protected void setComponentByIndex(FullConfigBuilder f1, int index) throws JAXBException {
		RamDao ramDao = new RamDao(); 
		Ram componentToSet = ramDao.getComponent(index);
		f1.setRam(componentToSet);
	}

	@Override
	public ComponentDao<?,?> getComponentDao() {
		return new RamDao();
	}

	@Override
	public ArrayList<Ram> getCompatibleComponents(FullConfigBuilder f1) throws JAXBException {
		if(f1.getMyMotherboard() != null)
			return CompatibilityCheckAlgs.getCompatibleRamsByMotherboard(f1);
		else
		{
			RamDao ramDao = new RamDao();
			return ramDao.readComponents();
		}
		
	}


}
