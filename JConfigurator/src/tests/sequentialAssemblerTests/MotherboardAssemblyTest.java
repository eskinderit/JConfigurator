package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Case;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Ram;
import dataSource.MotherboardDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.MotherboardAssembly;

class MotherboardAssemblyTest {

	ComponentAssembly motherboardAssembly;
	MotherboardDao motherboardDao;
	FullConfigBuilder f1 = FullConfigBuilder.getIstance();


	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		motherboardAssembly = new MotherboardAssembly();
		motherboardDao = new MotherboardDao();
		motherboardDao.setEmptyComponents();
		f1 = null;
		f1 = FullConfigBuilder.getIstance();
		
		f1.cpu(null);
		f1.gpu(null);
		f1.motherboard(null);
		f1.case1(null);
		f1.ram(null);
		f1.storage(null);
	}
	
	


	@Test
	void getCompatibleComponentsTestBySocket() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3); 
		Motherboard motherboard2 = new Motherboard("Asus prime h270 plus (lga1151 DDR4)", 108, 10, "LGA1151", "H270", "DDR4", false, 3); 
		Motherboard motherboard3 = new Motherboard("MSI b350m (AM4 DDR4)", 89, 10, "AM4", "b350m", "DDR4", true, 3); 

		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);
		motherboardList.add(motherboard3);


		motherboardDao.addComponents(motherboardList);
		Cpu cpu = new Cpu("CpuProva", 43, 3, "AM4", false);

		f1.cpu(cpu);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard1), "Comparing incompatible Motherboard and Cpu: different sockets");
		assertTrue(compatibleComponents.contains(motherboard3), "Comparing compatible Motherboard and Cpu: same sockets");
		
		f1.cpu(null);

	}

	@Test
	void getCompatibleComponentsTestBySize() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Atx", 66, 10, "LGA1151", "H110", "DDR3", false, 3); 
		Motherboard motherboard2 = new Motherboard("MSI uAtx", 108, 10, "LGA1151", "H270", "DDR4", false, 2); 
		Motherboard motherboard3 = new Motherboard("MSI mini-itx", 89, 10, "AM4", "b350m", "DDR4", true, 1); 

		
		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);
		motherboardList.add(motherboard3);

		motherboardDao.addComponents(motherboardList);
		Case case1 = new Case("Corsair Mini itx", 55, 10, 1);

		f1.case1(case1);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard1), "Comparing incompatible Motherboard and Case: Motherboard bigger in size");
		assertFalse(compatibleComponents.contains(motherboard2), "Comparing incompatible Motherboard and Case: Motherboard bigger in size");
		assertTrue(compatibleComponents.contains(motherboard3), "Comparing compatible Motherboard and Case: Motherboard has equal size to Case");
		f1.case1(null);

	}

	@Test
	void getCompatibleComponentsTestByRamType() throws JAXBException {

		Motherboard motherboard1 = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3); 
		Motherboard motherboard2 = new Motherboard("Asus prime h270 plus (lga1151 DDR4)", 108, 10, "LGA1151", "H270", "DDR4", false, 3); 
		
		
		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);

		motherboardDao.addComponents(motherboardList);
		Ram ram = new Ram("Ballistix Hyper",53,10, "DDR3",16);

		f1.ram(ram);

		ArrayList<Motherboard> compatibleComponents = motherboardAssembly.getCompatibleComponents(f1);

		assertFalse(compatibleComponents.contains(motherboard2), "Comparing incompatible Motherboard and Ram: different ramType");
		assertTrue(compatibleComponents.contains(motherboard1), "Comparing compatible Motherboard and Ram: same ramType");
		
		f1.ram(null);

	}

	@Test
	void getComponentsByIndex() throws JAXBException {
		
		Motherboard motherboard0 = new Motherboard("MSI Atx", 66, 10, "LGA1151", "H110", "DDR3", false, 3); 
		Motherboard motherboard1 = new Motherboard("MSI uAtx", 108, 10, "LGA1151", "H270", "DDR4", false, 2); 
		Motherboard motherboard2 = new Motherboard("MSI mini-itx", 89, 10, "AM4", "b350m", "DDR4", true, 1); 

		
		ArrayList<Motherboard> motherboardList = new ArrayList<>();
		motherboardList.add(motherboard0);
		motherboardList.add(motherboard1);
		motherboardList.add(motherboard2);

		motherboardDao.addComponents(motherboardList);

		motherboardAssembly.InputBasedBehavior(motherboardAssembly, f1 , "0");
		assertEquals(f1.getMyMotherboard(), motherboard0, "Comparing the Case with right index");
		assertNotEquals(f1.getMyMotherboard(),  motherboard1, "Choosing the Case with wrong index");

	}


	@AfterAll
	static void  clean() throws JAXBException 
	{
		MotherboardDao motherboardDao1 = new MotherboardDao();
		motherboardDao1.setDefaultComponents();
	}

}
