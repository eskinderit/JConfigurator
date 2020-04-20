package dataSource;


import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;


import ConfiguratorEngine.Psu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PsuDao extends ComponentDao<Psu>{

	@XmlElement(name="Psu")
	private ArrayList<Psu> psuList;

	
	@Override
	public ArrayList<Psu> getComponentList() {
		return psuList;
	}

	@Override
	public ArrayList<Psu> readComponents() throws JAXBException{
		return this.<PsuDao>_readComponents ("src/dataSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<PsuDao>_removeComponents (toDeleteList,"src/dataSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> addComponents(ArrayList<Psu> toAddList) throws JAXBException{
		return this.<PsuDao>_addComponents ("src/dataSource/Psu.Xml",toAddList, PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> setDefaultComponents() throws JAXBException {
		return this.<PsuDao>_setDefaultComponents("src/dataSource/PsuDefault.Xml","src/dataSource/Psu.Xml", PsuDao.class);
	}


}
