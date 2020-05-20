package dataSource;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import configuratorEngine.ComputerShop;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ComputerShopDao extends ComponentDao<ComputerShop, ComputerShopDao> {

	@XmlElement(name = "ComputerShop")
	private ArrayList<ComputerShop> computerShopList;

	public ComputerShopDao() {
		super();
		this.computerShopList = new ArrayList<ComputerShop>();
	}

	@Override
	protected void setComponentList(ArrayList<ComputerShop> componentList) {
		this.computerShopList = componentList;
	}

	@Override
	protected ArrayList<ComputerShop> getComponentList() {
		return this.computerShopList;
	}

	@Override
	public ArrayList<ComputerShop> readComponents() throws JAXBException {
		this.computerShopList = this._readComponents("src/dataSource/xmlSource/ComputerShop.Xml",
				ComputerShopDao.class);
		return this.computerShopList;
	}

	@Override
	public ArrayList<ComputerShop> deleteComponents(ArrayList<ComputerShop> toDeleteList) throws JAXBException {
		this.computerShopList = this._removeComponents(toDeleteList, "src/dataSource/xmlSource/ComputerShop.Xml",
				ComputerShopDao.class);
		return this.computerShopList;
	}

	@Override
	public ArrayList<ComputerShop> addComponents(ArrayList<ComputerShop> toAddList) throws JAXBException {
		this.computerShopList = this._addComponents("src/dataSource/xmlSource/ComputerShop.Xml", toAddList,
				ComputerShopDao.class);
		return this.computerShopList;
	}

	@Override
	public ArrayList<ComputerShop> setDefaultComponents() throws JAXBException {
		this.computerShopList = this._setDefaultComponents("src/dataSource/xmlSource/ComputerShopDefault.Xml",
				"src/dataSource/xmlSource/ComputerShop.Xml", ComputerShopDao.class);
		return this.computerShopList;
	}

	@Override
	public ArrayList<ComputerShop> setEmptyComponents() throws JAXBException {
		this.computerShopList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyComputerShop.Xml",
				"src/dataSource/xmlSource/ComputerShop.Xml", ComputerShopDao.class);
		return this.computerShopList;
	}

}
