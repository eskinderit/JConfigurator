package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.ComputerShop;
import ConfiguratorEngine.FullConfig;
import dataSource.ComputerShopDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.ComputerShopAssembly;

class ComputerShopAssemblyTest {
	
	ComponentAssembly computerShopAssembly;
	ComputerShopDao computerShopDao;
	FullConfig f1;

	
	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		computerShopAssembly = new ComputerShopAssembly();
		computerShopDao = new ComputerShopDao();
		computerShopDao.setEmptyComponents();
		f1 = new FullConfig();
	}
	
	@Test
	void getComponentsByIndex() throws JAXBException {
		ComputerShop computerShop0 = new ComputerShop("Prova0", 20, "viale redi");
		ComputerShop computerShop1 = new ComputerShop("Prova1", 20, "viale redi");
		ComputerShop computerShop2 = new ComputerShop("Prova2", 20, "viale redi");
		ComputerShop computerShop3 = new ComputerShop("Prova3", 20, "viale redi");
		
		ArrayList<ComputerShop> computerShopList = new ArrayList<>();
		computerShopList.add(computerShop0);
		computerShopList.add(computerShop1);
		computerShopList.add(computerShop2);
		computerShopList.add(computerShop3);
		
		computerShopDao.addComponents(computerShopList);
		

		computerShopAssembly.InputBasedBehavior(computerShopAssembly, f1 , "0");
		assertEquals(f1.getComputerShop(), computerShop0, "Comparing the expected component with the one obtained through the InputBasedBehavior method");
		assertNotEquals(f1.getComputerShop(), computerShop1, "Comparing the NOT expected component with the one obtained through the InputBasedBehavior method");
		
	}

	
	@AfterAll
	static void  clean() throws JAXBException 
	{
		ComputerShopDao computerShopDao1 = new ComputerShopDao();
		computerShopDao1.setDefaultComponents();
	}
	
}
