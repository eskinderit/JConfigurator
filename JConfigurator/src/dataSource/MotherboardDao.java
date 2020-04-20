package dataSource;

import ConfiguratorEngine.Motherboard;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MotherboardDao extends ComponentDao<Motherboard>{
	 
	@XmlElement(name="Motherboard")
	private ArrayList<Motherboard> motherboardList;
	
	@Override
	public ArrayList<Motherboard> getComponentList() {
		return motherboardList;
	}

	@Override
	public ArrayList<Motherboard> readComponents() throws JAXBException{
		return this.<MotherboardDao>_readComponents ("src/dataSource/Motherboard.Xml", MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<MotherboardDao>_removeComponents (toDeleteList,"src/dataSource/Motherboard.Xml", MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> addComponents(ArrayList<Motherboard> toAddList) throws JAXBException{
		return this.<MotherboardDao>_addComponents ("src/dataSource/Motherboard.Xml",toAddList, MotherboardDao.class);
	}
	
	@Override
	public ArrayList<Motherboard> setDefaultComponents() throws JAXBException {
		return this.<MotherboardDao>_setDefaultComponents("src/dataSource/MotherboardDefault.Xml","src/dataSource/Motherboard.Xml", MotherboardDao.class);
	}


}
