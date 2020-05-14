package testNonSequentialAssembler;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfigBuilder;
import nonSequentialAssembler.CaseSelection;
import nonSequentialAssembler.CorrectComponentsSelection;
import nonSequentialAssembler.CpuSelection;
import nonSequentialAssembler.GpuSelection;
import nonSequentialAssembler.MotherboardSelection;
import nonSequentialAssembler.RamSelection;
import nonSequentialAssembler.StorageSelection;


public class CastTests {
	CorrectComponentsSelection c;
	FullConfigBuilder f;
	ArrayList<Component> componentList;
	
	@BeforeEach
	public void init() {
		c=new CorrectComponentsSelection();
		f=new FullConfigBuilder();
		componentList = new ArrayList<Component>();
	}
	
	@Test
	public void testCpuList() throws JAXBException  {
		
		String a = "a";
		CpuSelection cpuList = new CpuSelection();
		
		componentList = c.createCorrectList(a, f);
		assertEquals(cpuList.getCompatibleComponents(f), componentList, "Test component-cpu cast");
	}
	
	@Test
	public void testGpuList() throws JAXBException {
		
		String b = "b";
		GpuSelection gpuList = new GpuSelection();
		
		componentList = c.createCorrectList(b, f);
		
		assertEquals(gpuList.getCompatibleComponents(f), componentList, "Test component-gpu cast");
	}
	
	@Test
	public void testMotherboardList() throws JAXBException {
		String c1 = "c";
		MotherboardSelection motherboardList = new MotherboardSelection();
		
		componentList = c.createCorrectList(c1, f);
		
		assertEquals(motherboardList.getCompatibleComponents(f), componentList, "Test component-motherboard cast");
	}
	
	
	@Test
	public void testCaseList() throws JAXBException {
		String d = "d";
		CaseSelection caseList = new CaseSelection();
		
		componentList = c.createCorrectList(d, f);
		
		assertEquals(caseList.getCompatibleComponents(f), componentList, "Test component-case cast");
	}
	
	@Test
	public void testRamList() throws JAXBException {
		String e = "e";
		RamSelection ramList = new RamSelection();
		
		componentList = c.createCorrectList(e, f);
		
		assertEquals(ramList.getCompatibleComponents(f), componentList, "Test component-ram cast");
	}
	
	@Test
	public void testStorageList() throws JAXBException {
		String f1 = "f";
		StorageSelection storageList = new StorageSelection();
		
		componentList = c.createCorrectList(f1, f);
		
		assertEquals(storageList.getCompatibleComponents(f), componentList, "Test component-storage cast");
	}
	
}

