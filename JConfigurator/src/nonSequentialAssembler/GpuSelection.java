package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class GpuSelection implements ComponentSelection{
	private GpuDao gpuList;
	private int size;
	
	public GpuSelection() throws JAXBException {
		gpuList = new GpuDao();
		size = gpuList.readComponents().size();
	}
	@Override
	public ArrayList<Gpu> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		size = gpuList.readComponents().size();
		return gpuList.readComponents();
	}

	@Override
	public int getSize() throws JAXBException {
		return size;
	}

}
