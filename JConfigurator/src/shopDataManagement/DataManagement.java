package shopDataManagement;

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
}
