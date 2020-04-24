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
	void init() throws JAXBException{
		caseDao = new CaseDao();
		caseDao.setEmptyComponents();
	}
	
	@Test
	void testSingleAdd() throws JAXBException{
		
		Case demoCase= new Case("Prova",23,20,3);
		ArrayList<Case> caseList = new ArrayList<>();
		ArrayList<Case> caseListLocal = caseDao.readComponents();
		caseListLocal.add(demoCase);
		caseList.add(demoCase);
		ArrayList<Case> readedCaseList = caseDao.addComponents(caseList);

		assertEquals(caseListLocal, readedCaseList, "Case Single Insert");	
	}
	
	
	@Test
	void testSingleRemove() throws JAXBException{
		

		ArrayList<Case> caseListLocal = caseDao.readComponents();
		Case c1 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3);

		caseListLocal.remove(c1);
		
		ArrayList<Case> casesToDelete = new ArrayList<Case>();
		casesToDelete.add(c1);
		ArrayList<Case> readedCaseList= caseDao.deleteComponents(casesToDelete);

		assertEquals(caseListLocal, readedCaseList, "Case Single Remove");	

	}
	
	
	
	@Test
	void testSet() throws JAXBException{
		
		caseDao.setDefaultComponents();
		
		CaseDao localCaseDao = new CaseDao();
		
		
		ArrayList<Case> newCaseList = new ArrayList<>();
		Case c1 = new Case("Prova1",1,2,3);
		newCaseList.add(c1);
	
		
		assertEquals(localCaseDao.readComponents(), caseDao.readComponents());
		
		localCaseDao.setDefaultComponents();

		assertEquals(localCaseDao.readComponents(), caseDao.readComponents(), "Case Set Default Components");

	}
	
	@Test
	void testEmpty() throws JAXBException{
		
		CaseDao myDao = new CaseDao();
		myDao.setEmptyComponents();
		
		
		assertEquals(myDao.readComponents(), caseDao.readComponents());
		
		
	}
	
	
	@Test
	void testEmptyAndAdd() throws JAXBException{
		
		CaseDao myDao = new CaseDao();
		
		
		Case c1 = new Case("Prova",1,2,3);
		ArrayList<Case> toAddList = new ArrayList<>();
		
		toAddList.add(c1);
		
		caseDao.setEmptyComponents();
		caseDao.addComponents(toAddList);
		
		assertEquals(myDao.readComponents(), caseDao.readComponents());
		
		
	}
	
	
	@AfterEach
	void clearAll() throws JAXBException {
		caseDao.setEmptyComponents();
	}



}
