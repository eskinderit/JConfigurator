package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Storage;
import dataSource.StorageDao;

public class SelectStorage extends SelectComponent{
	private StorageDao storage;
	public SelectStorage() {
		storage=new StorageDao();
	}
	
	
	@Override
	public void readComponent() throws JAXBException{
		System.out.println("Select a Storage from list:\n");
		for(Storage s:storage.readComponents()) {
			System.out.println(s);
		}
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		f.setStorage(storage.readComponents().get(n));
	}


	@Override
	public <T extends Component> ArrayList<T> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}
}
