package dataSource;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ConfiguratorEngine.Gpu;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao extends ComponentDao<Gpu, GpuDao> {

	@XmlElement(name = "Gpu")
	ArrayList<Gpu> gpuList;

	public GpuDao() {
		super();
		this.gpuList = new ArrayList<Gpu>();
	}

	@Override
	protected void setComponentList(ArrayList<Gpu> componentList) {
		this.gpuList = componentList;
	}

	@Override
	protected ArrayList<Gpu> getComponentList() {
		return this.gpuList;
	}

	@Override
	public ArrayList<Gpu> readComponents() throws JAXBException {
		this.gpuList = this._readComponents("src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
		return this.gpuList;
	}

	@Override
	public ArrayList<Gpu> deleteComponents(ArrayList<Gpu> toDeleteList) throws JAXBException {
		this.gpuList = this._removeComponents(toDeleteList, "src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
		return this.gpuList;
	}

	@Override
	public ArrayList<Gpu> setDefaultComponents() throws JAXBException {
		this.gpuList = this._setDefaultComponents("src/dataSource/xmlSource/GpuDefault.Xml",
				"src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
		return this.gpuList;
	}

	@Override
	public ArrayList<Gpu> addComponents(ArrayList<Gpu> toAddList) throws JAXBException {

		this.gpuList = this._addComponents("src/dataSource/xmlSource/Gpu.Xml", toAddList, GpuDao.class);
		return this.gpuList;
	}

	@Override
	public ArrayList<Gpu> setEmptyComponents() throws JAXBException {
		this.gpuList = this._setDefaultComponents("src/dataSource/xmlSource/EmptyGpu.Xml",
				"src/dataSource/xmlSource/Gpu.Xml", GpuDao.class);
		return this.gpuList;
	}

}