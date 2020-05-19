package tests.shopDataManagementTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ConfiguratorEngine.Case;
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
	}
	
	@BeforeEach
	public void init() throws JAXBException {
		caseList = caseDao.readComponents();
		caseData = new CaseDataManagement();
	}
	
	@Test
	public void deleteCaseTest() throws JAXBException {
		int index = (int)Math.random() * (caseDao.readComponents().size());
		assertNotEquals(caseData.deleteComp(index), caseList, " ");
		caseList.remove(index);
		assertEquals(caseDao.readComponents(), caseList, " ");
	}
	
	@Test
	public void addCaseTest() throws JAXBException {
		Scanner parameter = new Scanner(System.in);
		caseData.addComp(parameter);
		assertNotEquals(caseDao.readComponents(), caseList, " ");
		Case caseToAdd = new Case(caseData.name, caseData.price, caseData.power, caseData.size);
		caseList.add(caseToAdd);
		assertEquals(caseDao.readComponents(), caseList, " ");
		parameter.close();
	}
	
	@Test 
	public void resetCasesTest() throws JAXBException {
		assertEquals(caseData.resetComp(), caseDao.setDefaultComponents(), " ");
	}
	
	@AfterEach
	public void restoreList() throws JAXBException {
		caseDao.setEmptyComponents();
		caseDao.addComponents(savedCases);
	}
	
}
