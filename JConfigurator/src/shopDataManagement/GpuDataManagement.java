package shopDataManagement;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuDataManagement extends ComponentDataManagement{

	@Override
	public ArrayList<Gpu> deleteComp(int index) throws JAXBException {
		ArrayList<Gpu> gpus = new ArrayList<Gpu>();
		GpuDao gpuDao = new GpuDao();
		gpus.add(gpuDao.readComponents().get(index));
		return gpuDao.deleteComponents(gpus);
	}

}
