package dataSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ConfiguratorEngine.Gpu;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao  {

	

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
	
	
	
	public static ArrayList<Gpu> readGpus() throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Gpu.Xml";
		  File fout = new File(s);
		  GpuDao gpuNew = (GpuDao)unm.unmarshal(fout); 		  
		  ArrayList<Gpu> gpuList1 = gpuNew.getGpuList(); 		  
		  return gpuList1;
		
	}
	public static  ArrayList<Gpu> addGpus(ArrayList<Gpu> gpuListToAdd) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Gpu.Xml";
		  File fout = new File(s);
		  GpuDao gpuDao = (GpuDao)unm.unmarshal(fout); 		   		  
		  
		  //Adding
		  
		  gpuDao.getGpuList().addAll(gpuListToAdd);
		  
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE); 
		  m.marshal(gpuDao,fout);
	  
		return gpuDao.getGpuList();
	}
	public static ArrayList<Gpu> resetDefaultGpus() throws JAXBException {

		  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); Marshaller m =
		  ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  
		  
		  Gpu gpu1=new Gpu("ASUS GTX 1050 2GB", 130, 85, 2); 
		  Gpu gpu2=new Gpu("Gigabyte GTX 1060 6GB", 290, 135, 6); 
		  Gpu gpu3=new Gpu("Gibabyte GTX 1070 8GB", 530, 190, 8); 
		  Gpu gpu4=new Gpu("Gibabyte GTX 1080 8GB", 655, 120, 8); 
		  Gpu gpu5=new Gpu("Palit Titan Z 12GB", 1170, 490, 12); 
		  Gpu gpu6=new Gpu("MSI GTX950 2GB", 139, 130, 2);
		  Gpu gpu7=new Gpu("KFA2 GTX1080 8GB", 730, 180, 8); 
		  Gpu gpu8=new Gpu("Gibabyte Aorus GTX 1080ti 11GB", 896, 230, 11); 
		  Gpu gpu9=new Gpu("Gigabyte GTX 980ti", 373, 258, 6);
		  
		  GpuDao gpuDao = new GpuDao();
		 
		  gpuDao.getGpuList().add(gpu1); 
		  gpuDao.getGpuList().add(gpu2);
		  gpuDao.getGpuList().add(gpu3);
		  gpuDao.getGpuList().add(gpu4);
		  gpuDao.getGpuList().add(gpu5);
		  gpuDao.getGpuList().add(gpu6);
		  gpuDao.getGpuList().add(gpu7);
		  gpuDao.getGpuList().add(gpu8);
		  gpuDao.getGpuList().add(gpu9);
		 
		  
		  
		  File fout = new File("src/dataSource/Gpu.Xml");
		  m.marshal(gpuDao,fout);
		  
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  GpuDao gpuNewDao = (GpuDao) unm.unmarshal(fout);
		  
		  return gpuNewDao.getGpuList();
		  

		 
	}
}
