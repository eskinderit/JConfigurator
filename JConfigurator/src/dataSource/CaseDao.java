package dataSource;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import ConfiguratorEngine.Case;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CaseDao extends ComponentDao<Case,CaseDao>{

	@XmlElement(name="Case")
	private ArrayList<Case> caseList;

	
	@Override
	public ArrayList<Case> getComponentList() {
		return this.caseList;
	}

	@Override
	public ArrayList<Case> readComponents() throws JAXBException{
		this.caseList = this._readComponents ("src/dataSource/xmlSource/Case.Xml", CaseDao.class);
		return this.caseList;
	}
	
	@Override
	public ArrayList<Case> deleteComponents(ArrayList<Case> toDeleteList) throws JAXBException{
		this.caseList = this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Case.Xml", CaseDao.class);
		return this.caseList;
	}
	
	@Override
	public ArrayList<Case> addComponents(ArrayList<Case> toAddList) throws JAXBException{
		this.caseList = this._addComponents ("src/dataSource/xmlSource/Case.Xml",toAddList, CaseDao.class);
		return this.caseList;
	}
	
	@Override
	public ArrayList<Case> setDefaultComponents() throws JAXBException {
		this.caseList = this._setDefaultComponents("src/dataSource/xmlSource/CaseDefault.Xml","src/dataSource/xmlSource/Case.Xml", CaseDao.class);
		return this.caseList;
	}
	@Override
	public ArrayList<Case> setEmptyComponents() throws JAXBException {
		this.caseList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyCase.Xml","src/dataSource/xmlSource/Case.Xml", CaseDao.class);
		return this.caseList;
	}

}
