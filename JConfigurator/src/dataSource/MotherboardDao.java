package dataSource;

import ConfiguratorEngine.Motherboard;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MotherboardDao extends ComponentDao<Motherboard, MotherboardDao>{
	 
	@XmlElement(name="Motherboard")
	private ArrayList<Motherboard> motherboardList;
	
	@Override
	public ArrayList<Motherboard> getComponentList() {
		return motherboardList;
	}

	@Override
	public ArrayList<Motherboard> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> addComponents(ArrayList<Motherboard> toAddList) throws JAXBException{
		return this._addComponents ("src/dataSource/xmlSource/Motherboard.Xml",toAddList, MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/MotherboardDefault.Xml","src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
	}


}
