package dataSource;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import javax.xml.bind.*;

import ConfiguratorEngine.Ram;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RamDao extends ComponentDao<Ram>{
	
	@XmlElement(name="Ram")
	ArrayList<Ram> ramList;
	

	
	@Override
	public ArrayList<Ram> getComponentList() {
		return ramList;
	}

	@Override
	public ArrayList<Ram> readComponents() throws JAXBException{
		return this.<RamDao>_readComponents ("src/dataSource/Ram.Xml", RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<RamDao>_removeComponents (toDeleteList,"src/dataSource/Ram.Xml", RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> addComponents(ArrayList<Ram> toAddList) throws JAXBException{
		return this.<RamDao>_addComponents ("src/dataSource/Ram.Xml",toAddList, RamDao.class);
	}
	
	@Override
	public ArrayList<Ram> setDefaultComponents() throws JAXBException {
		return this.<RamDao>_setDefaultComponents("src/dataSource/RamDefault.Xml","src/dataSource/Ram.Xml", RamDao.class);
	}

	
}
