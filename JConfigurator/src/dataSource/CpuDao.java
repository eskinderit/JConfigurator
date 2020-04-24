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
	
	public CpuDao() {
		super();
		this.cpuList = new ArrayList<Cpu>();
	}

	
	@Override
	protected void setComponentList(ArrayList<Cpu> componentList) {
		this.componentList = componentList;
		this.cpuList = componentList; 
	}
	
	@Override
	protected ArrayList<Cpu> getComponentList() {
		return this.cpuList;
	}

	@Override
	public ArrayList<Cpu> readComponents() throws JAXBException{
		
		this.cpuList = this._readComponents ("src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
		return this.cpuList;
	}
	@Override
	public ArrayList<Cpu> deleteComponents(ArrayList<Cpu>toDeleteList) throws JAXBException{
		
		this.cpuList = this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
		return this.cpuList;
	}
	@Override
	public ArrayList<Cpu> setDefaultComponents() throws JAXBException {
		
		this.cpuList = this._setDefaultComponents("src/dataSource/xmlSource/CpuDefault.Xml","src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
		return this.cpuList;
	}

	@Override
	public ArrayList<Cpu> addComponents(ArrayList<Cpu> toAddList) throws JAXBException {

		this.cpuList = this._addComponents ("src/dataSource/xmlSource/Cpu.Xml",toAddList, CpuDao.class);
		return this.cpuList;
	
	}
	
	
	@Override
	public ArrayList<Cpu> setEmptyComponents() throws JAXBException {
		this.cpuList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyCpu.Xml","src/dataSource/xmlSource/Cpu.Xml", CpuDao.class);
		return this.cpuList;
	}
	
	public Cpu getComponent (int i) {
		return cpuList.get(i);
	}
	
}
