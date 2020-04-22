package test.dataSource;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import dataSource.CaseDao;
import ConfiguratorEngine.Case;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class CaseDaoTest {
	
	CaseDao caseDao;

	@BeforeEach
	void init() {
		caseDao = new CaseDao();
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
	
	//TODO i test vano bene, ma visogna far si che le liste xxxDao facciano riferimento a xxx.xml azzerati. bisogna porvvedere a fornire una funzione che ripulisca tutto in ogni caso
	
	@Test
	void testSet() throws JAXBException{
		
		CaseDao localCaseDao = new CaseDao();

		
		ArrayList<Case> componentToBeCleaned = new ArrayList<>();
		Case case1 = new Case("Prova", 1, 2, 3);
		componentToBeCleaned.add(case1);
		
		caseDao.addComponents(componentToBeCleaned);
		localCaseDao.setDefaultComponents();
		
		Assert.assertNotEquals(localCaseDao.getComponentList(), caseDao.getComponentList());
		
		caseDao.setDefaultComponents();

		assertEquals(localCaseDao.getComponentList(), caseDao.getComponentList(), "Case Set Default Components");

	}
	
	
	@AfterEach
	void clearAll() throws JAXBException {
		caseDao.setDefaultComponents();
	}



}
