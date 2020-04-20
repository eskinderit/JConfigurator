package dataSource;


import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;


import ConfiguratorEngine.Psu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PsuDao extends ComponentDao<Psu, PsuDao>{

	@XmlElement(name="Psu")
	private ArrayList<Psu> psuList;

	
	@Override
	public ArrayList<Psu> getComponentList() {
		return psuList;
	}

	@Override
	public ArrayList<Psu> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> addComponents(ArrayList<Psu> toAddList) throws JAXBException{
		return this._addComponents ("src/dataSource/xmlSource/Psu.Xml",toAddList, PsuDao.class);
	}
	
	@Override
	public ArrayList<Psu> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/PsuDefault.Xml","src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
	}


}
