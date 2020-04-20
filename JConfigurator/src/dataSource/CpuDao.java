package dataSource;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ConfiguratorEngine.Cpu;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CpuDao extends ComponentDao{
	
	@XmlElement(name="Cpu")
	private ArrayList <Cpu> cpuList;
	
	
	@Override
	public ArrayList<Cpu> getComponentList() {
		return cpuList;
	}

	@Override
	public ArrayList<Cpu> readComponents() throws JAXBException{
		return ComponentDao.<Cpu,CpuDao>_readComponents ("src/dataSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return ComponentDao.<Cpu,CpuDao>_removeComponents (toDeleteList,"src/dataSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> setDefaultComponents() throws JAXBException {
		return ComponentDao.<Cpu,CpuDao>_setDefaultComponents("src/dataSource/CpuDefault.Xml","src/dataSource/Cpu.Xml", CpuDao.class);
	}

	@Override
	public ArrayList addComponents(ArrayList toAddList) throws JAXBException {

		return ComponentDao.<Cpu,CpuDao>_addComponents ("src/dataSource/Cpu.Xml",toAddList, CpuDao.class);
	}
	
	
}
