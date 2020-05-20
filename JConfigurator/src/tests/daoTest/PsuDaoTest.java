package tests.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Psu;
import dataSource.PsuDao;

public class PsuDaoTest {
	PsuDao psuDao;
	ArrayList<Psu> psuList;
	Psu psu1;
	Psu psu2;

	@BeforeEach
	void init() {
		psuDao = new PsuDao();
		psuList = new ArrayList<Psu>();
		psu1 = new Psu("psu1", 10, 10);
		psu2 = new Psu("psu2", 10, 10);
		psuList.add(psu1);
		psuList.add(psu2);
	}

	@Test
	void testAddComponents() throws JAXBException {
		ArrayList<Psu> localpsuList = psuDao.readComponents();

		psuDao.addComponents(psuList);
		localpsuList.addAll(psuList);

		assertEquals(localpsuList, psuDao.readComponents(), "Add a psu list");
	}

	@Test
	void testAddComponents_repeated() throws JAXBException {
		ArrayList<Psu> localpsuList = psuDao.readComponents();

		localpsuList.addAll(psuList);
		psuDao.addComponents(psuList);
		psuDao.addComponents(psuList);
		assertEquals(localpsuList, psuDao.readComponents(), "Can only add the same psuList once");
		psuDao.addComponents(psuList);
		localpsuList.addAll(psuList);
		assertNotEquals(localpsuList, psuDao.readComponents(), "Can only add the same psuList once");
	}

	@Test
	void testDeleteComponents() throws JAXBException {
		ArrayList<Psu> localpsuList = psuDao.readComponents();

		localpsuList.removeAll(psuList);
		psuDao.deleteComponents(psuList);

		assertEquals(localpsuList, psuDao.readComponents(), "Remove a psu list");

	}

	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Psu> localpsuList = new ArrayList<Psu>();

		psuDao.setEmptyComponents();
		assertEquals(localpsuList, psuDao.readComponents(), "Set an empty psu List");
	}

	@Test
	void testAddOnEmptyFile() throws JAXBException {
		psuDao.setEmptyComponents();
		psuDao.addComponents(psuList);

		assertEquals(psuDao.readComponents(), psuList, "Add elements on an empty file");
	}

	@AfterEach
	void clearAll() throws JAXBException {
		psuDao.setDefaultComponents();
	}
}