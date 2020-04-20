package dataSource;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import ConfiguratorEngine.Case;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CaseDao extends ComponentDao<Case>{

	@XmlElement(name="Case")
	private ArrayList<Case> caseList;

	
	@Override
	public ArrayList<Case> getComponentList() {
		return caseList;
	}

	@Override
	public ArrayList<Case> readComponents() throws JAXBException{
		return this.<CaseDao>_readComponents ("src/dataSource/Case.Xml", CaseDao.class);
	}
	
	@Override
	public ArrayList<Case> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<CaseDao>_removeComponents (toDeleteList,"src/dataSource/Case.Xml", CaseDao.class);
	}
	
	@Override
	public ArrayList<Case> addComponents(ArrayList<Case> toAddList) throws JAXBException{
		return this.<CaseDao>_addComponents ("src/dataSource/Case.Xml",toAddList, CaseDao.class);
	}
	
	@Override
	public ArrayList<Case> setDefaultComponents() throws JAXBException {
		return this.<CaseDao>_setDefaultComponents("src/dataSource/CaseDefault.Xml","src/dataSource/Case.Xml", CaseDao.class);
	}


}
