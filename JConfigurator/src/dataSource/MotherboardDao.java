package dataSource;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ConfiguratorEngine.Motherboard;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MotherboardDao extends ComponentDao<Motherboard, MotherboardDao> {

	@XmlElement(name = "Motherboard")
	private ArrayList<Motherboard> motherboardList;

	public MotherboardDao() {
		super();
		this.motherboardList = new ArrayList<Motherboard>();
	}

	@Override
	protected void setComponentList(ArrayList<Motherboard> componentList) {
		this.motherboardList = componentList;
	}

	@Override
	protected ArrayList<Motherboard> getComponentList() {
		return this.motherboardList;
	}

	@Override
	public ArrayList<Motherboard> readComponents() throws JAXBException {
		this.motherboardList = this._readComponents("src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
		return this.motherboardList;
	}

	@Override
	public ArrayList<Motherboard> deleteComponents(ArrayList<Motherboard> toDeleteList) throws JAXBException {
		this.motherboardList = this._removeComponents(toDeleteList, "src/dataSource/xmlSource/Motherboard.Xml",
				MotherboardDao.class);
		return this.motherboardList;
	}

	@Override
	public ArrayList<Motherboard> addComponents(ArrayList<Motherboard> toAddList) throws JAXBException {
		this.motherboardList = this._addComponents("src/dataSource/xmlSource/Motherboard.Xml", toAddList,
				MotherboardDao.class);
		return this.motherboardList;
	}

	@Override
	public ArrayList<Motherboard> setDefaultComponents() throws JAXBException {
		this.motherboardList = _setDefaultComponents("src/dataSource/xmlSource/MotherboardDefault.Xml",
				"src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
		return this.motherboardList;
	}

	@Override
	public ArrayList<Motherboard> setEmptyComponents() throws JAXBException {
		this.motherboardList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyMotherboard.Xml",
				"src/dataSource/xmlSource/Motherboard.Xml", MotherboardDao.class);
		return this.motherboardList;
	}

}
