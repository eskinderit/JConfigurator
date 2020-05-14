package testNonSequentialAssembler;

import nonSequentialAssembler.GpuSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.*;


import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;


public class GpuSelectionTest {
	FullConfigBuilder f;
	GpuSelection gpus;
	
	@BeforeEach
	public void init() throws JAXBException {
		f = new FullConfigBuilder();
		gpus = new GpuSelection();
	}
	
	@Test
	public void CompatibleGpus() throws JAXBException {
		GpuDao gpuDao = new GpuDao();
		ArrayList<Gpu> gpuList1 = new ArrayList<Gpu>();
		ArrayList<Gpu> gpuList2 = new ArrayList<Gpu>();
		
		gpuList1 = gpuDao.readComponents();
		gpuList2 = gpus.getCompatibleComponents(f);
		
		assertEquals(gpuList1, gpuList2, "Test compatible gpus");
	}
}
