package dataSource;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Gpu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao extends ComponentDao{


    @XmlElement(name="Gpu")
	ArrayList<Gpu> gpuList;


	@Override
	public ArrayList<Gpu> getComponentList() {
		return gpuList;
	}

	@Override
	public ArrayList<Gpu> readComponents() throws JAXBException{
		return ComponentDao.<Gpu,GpuDao>_readComponents ("src/dataSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return ComponentDao.<Gpu,GpuDao>_removeComponents (toDeleteList,"src/dataSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> setDefaultComponents() throws JAXBException {
		return ComponentDao.<Gpu,GpuDao>_setDefaultComponents("src/dataSource/GpuDefault.Xml","src/dataSource/Gpu.Xml", GpuDao.class);
	}

	@Override
	public ArrayList addComponents(ArrayList toAddList) throws JAXBException {

		return ComponentDao.<Gpu,GpuDao>_addComponents ("src/dataSource/Gpu.Xml",toAddList, GpuDao.class);
	}
	
	
	
}