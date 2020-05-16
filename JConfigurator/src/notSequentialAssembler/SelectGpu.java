package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import dataSource.GpuDao;

public class SelectGpu extends SelectComponent{
	private GpuDao gpuList;
	
	public SelectGpu () {
		gpuList=new GpuDao();
	}

	@Override
	public void readComponent() throws JAXBException {
		System.out.println("Select a Gpu from list:\n");
		for(Gpu g:gpuList.readComponents()) {
			System.out.println(g);
		}
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		f.setGpu(gpuList.readComponents().get(n));
	}

	@Override
	public <T extends Component> ArrayList<T> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

}
