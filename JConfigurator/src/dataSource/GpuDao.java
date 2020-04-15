package dataSource;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import ConfiguratorEngine.Gpu;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao {

    @XmlElementWrapper(name="GPUs")
    @XmlElement(name="GPU")
	ArrayList<Gpu> gpuList;
	
	public GpuDao() {
		gpuList = new ArrayList<Gpu>();
	}

	public ArrayList<Gpu> getGpuList() {
		return gpuList;
	}

	public void setGpuList(ArrayList<Gpu> gpuList) {
		this.gpuList = gpuList;
	}
	
	
}
