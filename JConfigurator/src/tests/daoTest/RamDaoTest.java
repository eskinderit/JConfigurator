package tests.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.Ram;
import dataSource.RamDao;

public class RamDaoTest {

	RamDao ramDao;
	ArrayList<Ram> ramList;
	Ram ram1;
	Ram ram2;

	@BeforeEach
	void init() {
		ramDao = new RamDao();
		ramList = new ArrayList<Ram>();
		ram1 = new Ram("ram1", 10, 10, "type", 10);
		ram2 = new Ram("ram2", 10, 10, "type", 10);
		ramList.add(ram1);
		ramList.add(ram2);
	}

	@Test
	void testAddComponents() throws JAXBException {
		ArrayList<Ram> localRamList = ramDao.readComponents();

		localRamList.addAll(ramList);
		ramDao.addComponents(ramList);

		assertEquals(localRamList, ramDao.readComponents(), "Add a Ram List");
	}

	@Test
	void testAddComponents_repeated() throws JAXBException {
		ArrayList<Ram> localramList = ramDao.readComponents();

		localramList.addAll(ramList);
		ramDao.addComponents(ramList);
		ramDao.addComponents(ramList);
		assertEquals(localramList, ramDao.readComponents(), "Can only add the same ramList once");
		ramDao.addComponents(ramList);
		localramList.addAll(ramList);
		assertNotEquals(localramList, ramDao.readComponents(), "Can only add the same ramList once");
	}

	@Test
	void testDeleteComponents() throws JAXBException {
		ArrayList<Ram> localRamList = ramDao.readComponents();
		localRamList.removeAll(ramList);
		ramDao.deleteComponents(ramList);

		assertEquals(localRamList, ramDao.readComponents(), "Remove a ram list");

	}

	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<Ram> localramList = new ArrayList<Ram>();
		ramDao.setEmptyComponents();

		assertEquals(localramList, ramDao.readComponents(), "Set an empty Ram List");

	}

	@Test
	void testAddOnEmptyFile() throws JAXBException {
		ramDao.setEmptyComponents();
		ramDao.addComponents(ramList);

		assertEquals(ramDao.readComponents(), ramList, "Add elements on an empty file");

	}

	@AfterEach
	void clearAll() throws JAXBException {
		ramDao.setDefaultComponents();
	}
}
