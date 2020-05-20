package tests.shopDataManagementTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Case;
import dataSource.CaseDao;
import shopDataManagement.CaseDataManagement;


public class CaseDataManagementTest {
	static CaseDao caseDao = new CaseDao();
	static ArrayList<Case> savedCases = new ArrayList<Case>();
	ArrayList<Case> caseList;
	CaseDataManagement caseData;
	
	@BeforeAll
	static void saveList () throws JAXBException {
		savedCases.addAll(caseDao.readComponents());
		
		Case c = new Case("Case1", 50, 50, 50);
		ArrayList<Case> caseToAdd = new ArrayList<Case>();
		caseToAdd.add(c);
		caseDao.addComponents(caseToAdd);
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		Case c = new Case("Case1", 50, 50, 50);
		ArrayList<Case> caseToAdd = new ArrayList<Case>();
		caseToAdd.add(c);
		caseDao.addComponents(caseToAdd);
		caseList = caseDao.readComponents();
		caseData = new CaseDataManagement();
		
	}
	
	@Test
	public void deleteCaseTest() throws JAXBException {
		
		int index = (int)(Math.random() * caseDao.readComponents().size());
		assertNotEquals(caseData.deleteComp(index), caseList, "Makes sure that components in Case.XML are not the same as before, after the deletion.");
		caseList.remove(index);
		assertEquals(caseDao.readComponents(), caseList, "Makes sure that the componenent was removed from Case.XML file");
	}
	
	@Test
	public void addCaseTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		caseData.addComp(parameter);
		assertNotEquals(caseDao.readComponents(), caseList, "Makes sure that components in Case.XML are not the same as before, after the addition.");
		Case caseToAdd = new Case(caseData.getName(), caseData.getPrice(), caseData.getPower(), caseData.getSize());
		caseList.add(caseToAdd);
		assertEquals(caseDao.readComponents(), caseList, "Makes sure that the componenent was added in Case.XML file");
		parameter.close();
	}
	
	@Test 
	public void resetCasesTest() throws JAXBException {
		assertEquals(caseData.resetComp(), caseDao.setDefaultComponents(), "Makes sure that Case.Xml file contains defauld data from CaseDefault.XML file");
	}
	
	@AfterAll
	public static void restoreList() throws JAXBException {
		caseDao.setEmptyComponents();
		caseDao.addComponents(savedCases);
	}
	
}
