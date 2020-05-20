package tests.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.ComputerShop;
import dataSource.ComputerShopDao;

class ComputerShopDaoTest {
	ComputerShopDao computerShopDao;
	ArrayList<ComputerShop> computerShopList;
	ComputerShop computerShop1;
	ComputerShop computerShop2;

	@BeforeEach
	void init() {
		computerShopDao = new ComputerShopDao();
		computerShopList = new ArrayList<ComputerShop>();
		computerShop1 = new ComputerShop("Tradeco", 20, "via datini");
		computerShop2 = new ComputerShop("Essedi", 10, "via erbosa");
		computerShopList.add(computerShop1);
		computerShopList.add(computerShop2);
	}

	@Test
	void testAddComponents() throws JAXBException {
		ArrayList<ComputerShop> localComputerShopList = computerShopDao.readComponents();

		computerShopDao.addComponents(computerShopList);
		localComputerShopList.addAll(computerShopList);

		assertEquals(localComputerShopList, computerShopDao.readComponents(), "Add a computershop list");

	}

	@Test
	void testAddComponents_repeated() throws JAXBException {
		ArrayList<ComputerShop> localComputerShopList = computerShopDao.readComponents();

		localComputerShopList.addAll(computerShopList);
		computerShopDao.addComponents(computerShopList);
		computerShopDao.addComponents(computerShopList);
		assertEquals(localComputerShopList, computerShopDao.readComponents(),
				"Can only add the same computershop once");
		computerShopDao.addComponents(computerShopList);
		localComputerShopList.addAll(computerShopList);
		assertNotEquals(localComputerShopList, computerShopDao.readComponents(),
				"Can only add the same computershop once");
	}

	@Test
	void testDeleteComponents() throws JAXBException {
		ArrayList<ComputerShop> localCpuList = computerShopDao.readComponents();

		localCpuList.removeAll(computerShopList);
		computerShopDao.deleteComponents(computerShopList);

		assertEquals(localCpuList, computerShopDao.readComponents(), "Remove a computershop list");

	}

	@Test
	void testSetEmptyComponents() throws JAXBException {
		ArrayList<ComputerShop> localCpuList = new ArrayList<ComputerShop>();

		computerShopDao.setEmptyComponents();
		assertEquals(localCpuList, computerShopDao.readComponents(), "Set an empty Computershop List");
	}

	@Test
	void testAddOnEmptyFile() throws JAXBException {
		computerShopDao.setEmptyComponents();
		computerShopDao.addComponents(computerShopList);

		assertEquals(computerShopDao.readComponents(), computerShopList, "Add elements on an empty file");
	}

	@AfterEach
	void clearAll() throws JAXBException {
		computerShopDao.setDefaultComponents();
	}
}
