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
public class CpuDao extends ComponentDao<Cpu, CpuDao>{
	
	@XmlElement(name="Cpu")
	private ArrayList <Cpu> cpuList;
	
	
	@Override
	public ArrayList<Cpu> getComponentList() {
		return cpuList;
	}

	@Override
	public ArrayList<Cpu> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
	}
	@Override
	public ArrayList<Cpu> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/CpuDefault.Xml","src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
	}

	@Override
	public ArrayList<Cpu> addComponents(ArrayList<Cpu> toAddList) throws JAXBException {

		return this._addComponents ("src/dataSource/xmlSource/Cpu.Xml",toAddList, CpuDao.class);
	}
	
	
}
