package test.dataSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import dataSource.CaseDao;
import ConfiguratorEngine.Case;

class CaseDaoTest {
	
	CaseDao caseDao;

	@BeforeEach
	void init() {
		caseDao = new CaseDao();
	}
	
	@Test
	void testSingleAdd() throws JAXBException{
		
		Case demoCase= new Case("Prova",23,20,3);
		Case demoCase1= new Case("Prova1",23,20,3);

		ArrayList<Case> caseList = new ArrayList<>();
		ArrayList<Case> caseListLocal = caseDao.readComponents();
		caseListLocal.add(demoCase);
		caseList.add(demoCase);
		ArrayList<Case> readedCaseList = caseDao.addComponents(caseList);

		assertEquals(caseListLocal, readedCaseList, "Case Single Insert");	
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		caseDao.setDefaultComponents();
	}



}
