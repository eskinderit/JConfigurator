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

	public PsuDao() {
		super();
		this.psuList = new ArrayList<Psu>();
	}
	
	
	@Override
	public void setComponentList(ArrayList<Psu> componentList) {
		this.componentList = componentList;
		this.psuList = componentList; 
	}
	
	
	@Override
	protected ArrayList<Psu> getComponentList() {
		return this.psuList;
	}

	@Override
	public ArrayList<Psu> readComponents() throws JAXBException{
		this.psuList = this._readComponents ("src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
		return this.psuList;
	}
	
	@Override
	public ArrayList<Psu> deleteComponents(ArrayList<Psu> toDeleteList) throws JAXBException{
		this.psuList = this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
		return this.psuList;
	}
	
	@Override
	public ArrayList<Psu> addComponents(ArrayList<Psu> toAddList) throws JAXBException{
		this.psuList = this._addComponents ("src/dataSource/xmlSource/Psu.Xml",toAddList, PsuDao.class);
		return this.psuList;
	}
	
	@Override
	public ArrayList<Psu> setDefaultComponents() throws JAXBException {
		this.psuList = this._setDefaultComponents("src/dataSource/xmlSource/PsuDefault.Xml","src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
		return this.psuList;
	}

	@Override
	public ArrayList<Psu> setEmptyComponents() throws JAXBException {
		this.psuList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyPsu.Xml","src/dataSource/xmlSource/Psu.Xml", PsuDao.class);
		return this.psuList;
	}
	public Psu getComponent (int i) {
		return psuList.get(i);
	}

}
