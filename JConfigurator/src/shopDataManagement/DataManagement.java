package shopDataManagement;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

public class DataManagement {
	
	public void deletec (int index, String component) throws JAXBException {
		if(component.contains("a")) {
			CpuDataManagement c = new CpuDataManagement();
			c.deleteComp(index);
		}
		else if(component.contains("b")){
			GpuDataManagement g = new GpuDataManagement();
			g.deleteComp(index);
		}
		else if(component.contains("c")) {
			MotherboardDataManagement m = new MotherboardDataManagement();
			m.deleteComp(index);
		}
		else if(component.contains("d")) {
			CaseDataManagement c1 = new CaseDataManagement();
			c1.deleteComp(index);
		}
		else if(component.contains("e")) {
			RamDataManagement r = new RamDataManagement();
			r.deleteComp(index);
		}
		else if(component.contains("f")) {
			StorageDataManagement s = new StorageDataManagement();
			s.deleteComp(index);
		}
		else {
			PsuDataManagement p = new PsuDataManagement();
			p.deleteComp(index);
		}
	}
	
	public void addc (String component, Scanner parameter) throws JAXBException {
		if(component.contains("a")) {
			CpuDataManagement c = new CpuDataManagement();
			c.addComp(parameter);
		}
		
		else if (component.contains("b")) {
			GpuDataManagement g = new GpuDataManagement();
			g.addComp(parameter);
		}
		
		else if (component.contains("c")){
			MotherboardDataManagement m = new MotherboardDataManagement();
			m.addComp(parameter);
		}
		
		else if(component.contains("d")){
			CaseDataManagement c1 = new CaseDataManagement();
			c1.addComp(parameter);
		}
		else if(component.contains("e"))  {
			RamDataManagement r = new RamDataManagement();
			r.addComp(parameter);
		}
		else if(component.contains("f")){
			StorageDataManagement s = new StorageDataManagement();
			s.addComp(parameter);
		}
		
		else {
			PsuDataManagement p = new PsuDataManagement();
			p.addComp(parameter);
		}
	}
	
	public void resetc (String component) throws JAXBException {
		if(component.contains("a")) {
			CpuDataManagement c = new CpuDataManagement();
			c.resetComp();
		}
		
		else if (component.contains("b")) {
			GpuDataManagement g = new GpuDataManagement();
			g.resetComp();
		}
		
		else if (component.contains("c")){
			MotherboardDataManagement m = new MotherboardDataManagement();
			m.resetComp();
		}
		
		else if(component.contains("d")){
			CaseDataManagement c1 = new CaseDataManagement();
			c1.resetComp();
		}
		else if(component.contains("e"))  {
			RamDataManagement r = new RamDataManagement();
			r.resetComp();
		}
		else if(component.contains("f")){
			StorageDataManagement s = new StorageDataManagement();
			s.resetComp();
		}
		
		else {
			PsuDataManagement p = new PsuDataManagement();
			p.resetComp();
		}
	}
}
