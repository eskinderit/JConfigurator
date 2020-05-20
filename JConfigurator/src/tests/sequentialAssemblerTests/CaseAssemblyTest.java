package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Case;
import configuratorEngine.FullConfig;
import configuratorEngine.Motherboard;
import dataSource.CaseDao;
import sequentialAssembler.CaseAssembly;
import sequentialAssembler.ComponentAssembly;

class CaseAssemblyTest {

	ComponentAssembly<Case> caseAssembly;
	CaseDao caseDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		caseAssembly = new CaseAssembly();
		caseDao = new CaseDao();
		caseDao.setEmptyComponents();
		f1 = new FullConfig();
	}

	@Test
	void getCompatibleComponentsTest() throws JAXBException {
		Case case0 = new Case("Prova0", 2, 3, 1);
		Case case1 = new Case("Prova1", 15, 26, 2);
		Case case2 = new Case("Prova2", 2, 3, 3);
		Case case3 = new Case("Prova3", 15, 26, 4);

		ArrayList<Case> caseList = new ArrayList<>();
		caseList.add(case0);
		caseList.add(case1);
		caseList.add(case2);
		caseList.add(case3);

		caseDao.addComponents(caseList);
		Motherboard motherboard = new Motherboard("MotherboardProva", 43, 3, "LGA1150", "Z77", "DDR3", false, 2);

		f1.setMotherboard(motherboard);

		ArrayList<Case> compatibleComponents = caseAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(case0),
				"Comparing a motherboard with uncompatible (smaller size) case");
		assertTrue(compatibleComponents.contains(case1), "Comparing a motherboard with compatible (equal size) case");
		assertTrue(compatibleComponents.contains(case2), "Comparing a motherboard with compatible (bigger size) case");
		assertTrue(compatibleComponents.contains(case3), "Comparing a motherboard with compatible (bigger size) case");

	}

	@Test
	void getComponentsByIndex() throws JAXBException {
		Case case0 = new Case("Prova0", 2, 3, 1);
		Case case1 = new Case("Prova1", 15, 26, 2);
		Case case2 = new Case("Prova2", 2, 3, 3);
		Case case3 = new Case("Prova3", 15, 26, 4);

		ArrayList<Case> caseList = new ArrayList<>();
		caseList.add(case0);
		caseList.add(case1);
		caseList.add(case2);
		caseList.add(case3);

		caseDao.addComponents(caseList);
		caseAssembly.InputBasedBehavior(f1, "0");
		assertEquals(f1.getCase0(), case0, "Comparing the Case with right index");
		assertNotEquals(f1.getCase0(), case1, "Choosing the Case with wrong index");

	}

	@AfterAll
	static void clean() throws JAXBException {
		CaseDao caseDao1 = new CaseDao();
		caseDao1.setDefaultComponents();
	}

}
