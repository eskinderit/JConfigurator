package dataSource;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import configuratorEngine.Ram;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RamDao extends ComponentDao<Ram, RamDao> {

	@XmlElement(name = "Ram")
	ArrayList<Ram> ramList;

	public RamDao() {
		super();
		this.ramList = new ArrayList<Ram>();
	}

	@Override
	protected void setComponentList(ArrayList<Ram> componentList) {
		this.ramList = componentList;
	}

	@Override
	protected ArrayList<Ram> getComponentList() {
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> readComponents() throws JAXBException {
		this.ramList = this._readComponents("src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> deleteComponents(ArrayList<Ram> toDeleteList) throws JAXBException {
		this.ramList = this._removeComponents(toDeleteList, "src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> addComponents(ArrayList<Ram> toAddList) throws JAXBException {
		this.ramList = this._addComponents("src/dataSource/xmlSource/Ram.Xml", toAddList, RamDao.class);
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> setDefaultComponents() throws JAXBException {
		this.ramList = this._setDefaultComponents("src/dataSource/xmlSource/RamDefault.Xml",
				"src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}

	@Override
	public ArrayList<Ram> setEmptyComponents() throws JAXBException {
		this.ramList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyRam.Xml",
				"src/dataSource/xmlSource/Ram.Xml", RamDao.class);
		return this.ramList;
	}

}
