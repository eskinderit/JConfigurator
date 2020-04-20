package dataSource;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import ConfiguratorEngine.Gpu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao extends ComponentDao<Gpu>{


    @XmlElement(name="Gpu")
	ArrayList<Gpu> gpuList;


	@Override
	public ArrayList<Gpu> getComponentList() {
		return gpuList;
	}

	@Override
	public ArrayList<Gpu> readComponents() throws JAXBException{
		return this.<GpuDao>_readComponents ("src/dataSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this.<GpuDao>_removeComponents (toDeleteList,"src/dataSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> setDefaultComponents() throws JAXBException {
		return this.<GpuDao>_setDefaultComponents("src/dataSource/GpuDefault.Xml","src/dataSource/Gpu.Xml", GpuDao.class);
	}

	@Override
	public ArrayList<Gpu> addComponents(ArrayList<Gpu> toAddList) throws JAXBException {

		return this.<GpuDao>_addComponents ("src/dataSource/Gpu.Xml",toAddList, GpuDao.class);
	}
	
	
	
}