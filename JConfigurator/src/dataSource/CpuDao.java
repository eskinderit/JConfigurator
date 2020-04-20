package dataSource;

import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ConfiguratorEngine.Cpu;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CpuDao extends ComponentDao<Cpu>{
	
	@XmlElement(name="Cpu")
	private ArrayList <Cpu> cpuList;
	
	
	@Override
	public ArrayList<Cpu> getComponentList() {
		return cpuList;
	}

	@Override
	public ArrayList<Cpu> readComponents() throws JAXBException{
		return this.<CpuDao>_readComponents ("src/dataSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<CpuDao>_removeComponents (toDeleteList,"src/dataSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> setDefaultComponents() throws JAXBException {
		return this.<CpuDao>_setDefaultComponents("src/dataSource/CpuDefault.Xml","src/dataSource/Cpu.Xml", CpuDao.class);
	}

	@Override
	public ArrayList<Cpu> addComponents(ArrayList<Cpu> toAddList) throws JAXBException {

		return this.<CpuDao>_addComponents ("src/dataSource/Cpu.Xml",toAddList, CpuDao.class);
	}
	
	
}
