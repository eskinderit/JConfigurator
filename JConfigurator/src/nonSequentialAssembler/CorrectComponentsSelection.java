package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Component;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import ConfiguratorEngine.Ram;
import ConfiguratorEngine.Storage;


public class CorrectComponentsSelection {

	public <T extends Component> ArrayList<T> createCorrectList(String s, FullConfigBuilder f) throws JAXBException{
		if(s.contentEquals("a")) {
			CpuSelection selectCpu = new CpuSelection();
			return (ArrayList<T>) selectCpu.getCompatibleComponents(f);
		}
		else if(s.contentEquals("b")) {
			GpuSelection selectGpu = new GpuSelection();
			return (ArrayList<T>) selectGpu.getCompatibleComponents(f);
		}
		else if(s.contentEquals("c")) {
			MotherboardSelection selectMotherboard = new MotherboardSelection();
			return (ArrayList<T>) selectMotherboard.getCompatibleComponents(f);
		}
		else if(s.contentEquals("d")) {
			CaseSelection selectCase = new CaseSelection();
			return (ArrayList<T>) selectCase.getCompatibleComponents(f);
		}
		else if(s.contentEquals("e")) {
			RamSelection selectRam = new RamSelection();
			return (ArrayList<T>) selectRam.getCompatibleComponents(f);
		}
		else {
			StorageSelection selectStorage = new StorageSelection();
			return (ArrayList<T>) selectStorage.getCompatibleComponents(f);
		}
		
	}
	
	public Boolean checkInput(String s) {
		if(s.contentEquals("a") || s.contentEquals("b") || s.contentEquals("c") || s.contentEquals("d") || s.contentEquals("e") || s.contentEquals("f"))
			return true;
		else
			return false;
	}
	
	public Boolean checkIndex(ArrayList<Component> a, int index, String s, FullConfigBuilder f) {
		if(index<a.size()) {
			if(s.contentEquals("a")) {
				f.cpu((Cpu) a.get(index));
			}
			else if(s.contentEquals("b")) {
				f.gpu((Gpu) a.get(index));
			}
			else if(s.contentEquals("c")) {
				f.motherboard((Motherboard) a.get(index));
			}
			else if(s.contentEquals("d")) {
				f.case1((Case) a.get(index));
			}
			else if(s.contentEquals("e")) {
				f.ram((Ram) a.get(index));;
			}
			else if(s.contentEquals("f")) {
				f.storage((Storage) a.get(index));
			}
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<Psu> createPsuList(FullConfigBuilder f) throws JAXBException{
		PsuSelection selectPsu = new PsuSelection();
		return selectPsu.getCompatibleComponents(f);
	}
}
