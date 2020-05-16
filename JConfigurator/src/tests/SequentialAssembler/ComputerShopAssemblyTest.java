package tests.SequentialAssembler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.ComputerShop;
import ConfiguratorEngine.FullConfigBuilder;
import dataSource.ComputerShopDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.ComputerShopAssembly;

class ComputerShopAssemblyTest {
	
	ComponentAssembly computerShopAssembly;
	ComputerShopDao computerShopDao;
	FullConfigBuilder f1 = FullConfigBuilder.getIstance();

	
	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		computerShopAssembly = new ComputerShopAssembly();
		computerShopDao = new ComputerShopDao();
		computerShopDao.setEmptyComponents();
		f1.setCpu(null);
		f1.setGpu(null);
		f1.setMotherboard(null);
		f1.setCase(null);
		f1.setRam(null);
		f1.setStorage(null);
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
		assertEquals(f1.getMyComputerShop(), computerShop0, "Comparing the expected component with the one obtained through the InputBasedBehavior method");
		assertNotEquals(f1.getMyComputerShop(), computerShop1, "Comparing the NOT expected component with the one obtained through the InputBasedBehavior method");
		
	}

	
	@AfterAll
	static void  clean() throws JAXBException 
	{
		ComputerShopDao computerShopDao1 = new ComputerShopDao();
		computerShopDao1.setDefaultComponents();
	}
	
}
