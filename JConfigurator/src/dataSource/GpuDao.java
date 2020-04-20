package dataSource;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import ConfiguratorEngine.Gpu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao extends ComponentDao<Gpu, GpuDao>{


    @XmlElement(name="Gpu")
	ArrayList<Gpu> gpuList;


	@Override
	public ArrayList<Gpu> getComponentList() {
		return gpuList;
	}

	@Override
	public ArrayList<Gpu> readComponents() throws JAXBException{
		return this._readComponents ("src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> deleteComponents(int toDeleteList[]) throws JAXBException{
		return this._removeComponents (toDeleteList,"src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
	}
	@Override
	public ArrayList<Gpu> setDefaultComponents() throws JAXBException {
		return this._setDefaultComponents("src/dataSource/xmlSource/GpuDefault.Xml","src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
	}

	@Override
	public ArrayList<Gpu> addComponents(ArrayList<Gpu> toAddList) throws JAXBException {

		return this._addComponents ("src/dataSource/xmlSource/Gpu.Xml",toAddList, GpuDao.class);
	}
	
	
	
}