package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Cpu;
import dataSource.CaseDao;
import dataSource.ComponentDao;
import dataSource.CpuDao;
import dataSource.GpuDao;
import dataSource.MotherboardDao;
import dataSource.PsuDao;
import dataSource.RamDao;
import dataSource.StorageDao;

public abstract class ComponentDataManagement {
	
	public static ComponentDao<?, ?> ComponentData(String c) throws JAXBException {
		
		if(c.contains("a")) {
			ComponentDao<?, ?> cpus = new CpuDao();
			return cpus;
		}
		else if(c.contains("b")) {
			GpuDao gpus = new GpuDao();
			return gpus;
		}
		else if(c.contains("c")){
			MotherboardDao motherboards = new MotherboardDao();
			return motherboards;
		}
		else if(c.contains("d")){
			CaseDao cases = new CaseDao();
			return cases;
		}
		else if(c.contains("e")){
			RamDao rams = new RamDao();
			return rams;
		}
		else if(c.contains("f")){
			StorageDao storages = new StorageDao();
			return storages;
		}
		else {
			PsuDao psus = new PsuDao();
			return psus;
		}
	}
	
	abstract public <T extends Component> ArrayList<T> deleteComp (int index) throws JAXBException;
	
	abstract public <T extends Component> ArrayList<T> addComp () throws JAXBException;
	
}
