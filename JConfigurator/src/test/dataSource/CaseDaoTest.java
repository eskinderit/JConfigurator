package test.dataSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Case;

import org.junit.jupiter.api.*;
import dataSource.CaseDao;

public class CaseDaoTest {
	CaseDao caseDao;
	ArrayList<Case> caseList;
	Case case1;
	Case case2;
	
	@BeforeEach
	void init() {
		caseDao=new CaseDao();
		caseList=new ArrayList<Case>();
		case1 = new Case("case1", 10, 10, 10);
		case2 = new Case("case2", 10, 10, 10);
		caseList.add(case1);
		caseList.add(case2);
	}
	
	@Test
	void testAddcaseList() throws JAXBException {
		ArrayList<Case> localcaseList=caseDao.readComponents();
		
		caseDao.addComponents(caseList);
		localcaseList.addAll(caseList);
		
		assertEquals(localcaseList, caseDao.readComponents(), "Add a case list");
	}
	
	@Test
	void testAddSameElements() throws JAXBException {
		ArrayList<Case> localcaseList=caseDao.readComponents();
		
		localcaseList.addAll(caseList);
		caseDao.addComponents(caseList);
		caseDao.addComponents(caseList);
		assertEquals(localcaseList, caseDao.readComponents(), "Can only add the same caseList once");
		caseDao.addComponents(caseList);
		localcaseList.addAll(caseList);
		assertNotEquals(localcaseList, caseDao.readComponents(), "Can only add the same caseList once");
	}
	
	@Test
	void testRemovecaseList() throws JAXBException {
		ArrayList<Case> localcaseList = caseDao.readComponents();
		
		localcaseList.removeAll(caseList);
		caseDao.deleteComponents(caseList);
		
		assertEquals(localcaseList, caseDao.readComponents(), "Remove a case list");
		
	}
	
	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Case> localcaseList = new ArrayList<Case>();
		
		caseDao.setEmptyComponents();
		assertEquals(localcaseList, caseDao.readComponents(), "Set an empty case List");
	}
	
	@Test
	void testAddOnEmptyFile() throws JAXBException {
		caseDao.setEmptyComponents();
		caseDao.addComponents(caseList);
		
		assertEquals(caseDao.readComponents(), caseList, "Add elements on an empty file");
	}
	
	@AfterEach
	void clearAll() throws JAXBException {
		caseDao.setDefaultComponents();
	}
}