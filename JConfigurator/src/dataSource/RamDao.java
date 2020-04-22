package dataSource;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import javax.xml.bind.*;

import ConfiguratorEngine.Ram;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RamDao extends ComponentDao<Ram, RamDao>{
	
	@XmlElement(name="Ram")
	ArrayList<Ram> ramList;
	
	@Override
	public ArrayList<Ram> getComponentList() {
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> readComponents() throws JAXBException{
		this.ramList = this._readComponents ("src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}
	
	@Override
	public ArrayList<Ram> deleteComponents(ArrayList<Ram> toDeleteList) throws JAXBException{
		this.ramList = this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}
	
	@Override
	public ArrayList<Ram> addComponents(ArrayList<Ram> toAddList) throws JAXBException{
		this.ramList = this._addComponents ("src/dataSource/xmlSource/Ram.Xml",toAddList, RamDao.class);
		return this.ramList;
	}
	
	@Override
	public ArrayList<Ram> setDefaultComponents() throws JAXBException {
		this.ramList = this._setDefaultComponents("src/dataSource/xmlSource/RamDefault.Xml","src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}

	
}
