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
		return ramList;
	}

	@Override
	public ArrayList<Ram> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Ram.Xml", RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Ram.Xml", RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> addComponents(ArrayList<Ram> toAddList) throws JAXBException{
		return this._addComponents ("src/dataSource/xmlSource/Ram.Xml",toAddList, RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/RamDefault.Xml","src/dataSource/xmlSource/Ram.Xml", RamDao.class);
	}

	
}
