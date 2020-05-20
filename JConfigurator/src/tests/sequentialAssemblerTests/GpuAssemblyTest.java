package tests.sequentialAssemblerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import configuratorEngine.FullConfig;
import configuratorEngine.Gpu;
import dataSource.GpuDao;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.GpuAssembly;

class GpuAssemblyTest {

	ComponentAssembly<Gpu> gpuAssembly;
	GpuDao gpuDao;
	FullConfig f1;

	@BeforeEach
	@AfterEach
	void init() throws JAXBException {
		gpuAssembly = new GpuAssembly();
		gpuDao = new GpuDao();
		gpuDao.setEmptyComponents();
		f1 = new FullConfig();
	}

	@Test
	void getComponentsByIndex() throws JAXBException {
		Gpu gpu0 = new Gpu("Prova0", 2, 3, 1);
		Gpu gpu1 = new Gpu("Prova1", 15, 26, 2);
		Gpu gpu2 = new Gpu("Prova2", 2, 3, 3);
		Gpu gpu3 = new Gpu("Prova3", 15, 26, 4);

		ArrayList<Gpu> gpuList = new ArrayList<>();
		gpuList.add(gpu0);
		gpuList.add(gpu1);
		gpuList.add(gpu2);
		gpuList.add(gpu3);

		gpuDao.addComponents(gpuList);

		gpuAssembly.InputBasedBehavior(f1, "0");
		assertEquals(f1.getGpu(), gpu0,
				"Comparing the expected component with the one obtained through the InputBasedBehavior method");
		assertNotEquals(f1.getGpu(), gpu1,
				"Comparing the NOT expected component with the one obtained through the InputBasedBehavior method");

	}

	@AfterAll
	static void clean() throws JAXBException {
		GpuDao gpuDao1 = new GpuDao();
		gpuDao1.setDefaultComponents();
	}

}
