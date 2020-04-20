package dataSource;


import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;


import ConfiguratorEngine.Psu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PsuDao extends ComponentDao{

	@XmlElement(name="Psu")
	private ArrayList<Psu> psuList;

	
	@Override
	public ArrayList<Psu> getComponentList() {
		return psuList;
	}

	@Override
	public ArrayList<Psu> readComponents() throws JAXBException{
		return ComponentDao.<Psu, PsuDao>_readComponents ("src/dataSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return ComponentDao.<Psu,PsuDao>_removeComponents (toDeleteList,"src/dataSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> addComponents(ArrayList toAddList) throws JAXBException{
		return ComponentDao.<Psu,PsuDao>_addComponents ("src/dataSource/Psu.Xml",toAddList, PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> setDefaultComponents() throws JAXBException {
		return ComponentDao.<Psu,PsuDao>_setDefaultComponents("src/dataSource/PsuDefault.Xml","src/dataSource/Psu.Xml", PsuDao.class);
	}


}
