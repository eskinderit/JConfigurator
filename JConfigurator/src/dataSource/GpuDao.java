package dataSource;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import ConfiguratorEngine.Gpu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GpuDao extends ComponentDao{


    @XmlElement(name="GPU")
	ArrayList<Gpu> gpuList;
    
  
    public GpuDao() {
	   this.gpuList = new ArrayList<Gpu>();
}

    
	  public ArrayList<Gpu> getGpuList() {
		return gpuList;
	}

	  @Override
	  public ArrayList<Gpu> getComponentList() {
		return gpuList;
	}


	public void setGpuList(ArrayList<Gpu> gpuList) {
		this.gpuList = gpuList;
	}


	public static ArrayList<Gpu> nuovaLettura() throws JAXBException{
		return ComponentDao.<Gpu,GpuDao>readComponents ("src/dataSource/Gpu.Xml", GpuDao.class);
	}
	
	public static ArrayList<Gpu> nuovaRimozione(int toDeleteList[]) throws JAXBException{
		return ComponentDao.<Gpu,GpuDao>removeComponents (toDeleteList,"src/dataSource/Gpu.Xml", GpuDao.class);
	}
	
	public static ArrayList<Gpu> nuovaAggiunta(ArrayList<Gpu> toAddList) throws JAXBException{
		return ComponentDao.<Gpu,GpuDao>addComponents ("src/dataSource/Gpu.Xml",toAddList, GpuDao.class);
	}
	
	//TODO rimuovere, l'ho deprecato
	public static ArrayList<Gpu> readGpus() throws JAXBException {
	  
	  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); Unmarshaller unm =
	  ctx.createUnmarshaller(); String s = "src/dataSource/Gpu.Xml"; File fout =
	  new File(s); GpuDao gpuNew = (GpuDao)unm.unmarshal(fout); ArrayList<Gpu>
	  gpuList1 = gpuNew.getGpuList(); 
	  return gpuList1;
	  
	  }
	 
	//TODO rimuovere, l'ho deprecato
	public static ArrayList<Gpu> removeComponents(int toDelete[]) throws JAXBException {
	  
	  Arrays.sort(toDelete);
	  //Reading
	  
	  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); Unmarshaller unm =
	  ctx.createUnmarshaller(); String s = "src/dataSource/Gpu.Xml"; 
	  File fout =new File(s);
	  GpuDao gpuDao = (GpuDao)unm.unmarshal(fout); //Subtracting
	  
	  //Deleting
	  for(int i=0; i<toDelete.length; i++) {
		  for (int j=0; j<gpuDao.getGpuList().size(); j++)
		  if (toDelete[i]==j) {
			  gpuDao.getGpuList().remove(j);
			  for (int k=i; k<toDelete.length;k++)
				  toDelete[k]=toDelete[k]-1;
		  }
	  }
	  //Rewriting
	  
	  Marshaller m = ctx.createMarshaller();
	  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
	  m.marshal(gpuDao,fout);
	  
	  return gpuDao.getGpuList(); }
	
	//TODO rimuovere, l'ho deprecato  
	public static ArrayList<Gpu> addComponents(ArrayList<Gpu> gpuListToAdd) throws JAXBException {
	  
	  //Reading
	  
	  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); Unmarshaller unm =
	  ctx.createUnmarshaller(); String s = "src/dataSource/Gpu.Xml"; File fout =
	  new File(s); GpuDao gpuDao = (GpuDao)unm.unmarshal(fout);
	  
	  //Adding
	  
	  gpuDao.getGpuList().addAll(gpuListToAdd);
	  
	  //Rewriting
	  
	  Marshaller m = ctx.createMarshaller();
	  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
	  m.marshal(gpuDao,fout);
	  
	  return gpuDao.getGpuList(); }
	  
	public static ArrayList<Gpu> resetDefaultComponents() throws JAXBException {
	  
	  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); Marshaller m =
	  ctx.createMarshaller();
	  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
	  
	  
	  Gpu gpu1=new Gpu("ASUS GTX 1050 2GB", 130, 85, 2); Gpu gpu2=new
	  Gpu("Gigabyte GTX 1060 6GB", 290, 135, 6); Gpu gpu3=new
	  Gpu("Gibabyte GTX 1070 8GB", 530, 190, 8); Gpu gpu4=new
	  Gpu("Gibabyte GTX 1080 8GB", 655, 120, 8); Gpu gpu5=new
	  Gpu("Palit Titan Z 12GB", 1170, 490, 12); Gpu gpu6=new Gpu("MSI GTX950 2GB",
	  139, 130, 2); Gpu gpu7=new Gpu("KFA2 GTX1080 8GB", 730, 180, 8); Gpu gpu8=new
	  Gpu("Gibabyte Aorus GTX 1080ti 11GB", 896, 230, 11); Gpu gpu9=new
	  Gpu("Gigabyte GTX 980ti", 373, 258, 6);
	  
	  GpuDao gpuDao = new GpuDao();
	  
	  gpuDao.getGpuList().add(gpu1); gpuDao.getGpuList().add(gpu2);
	  gpuDao.getGpuList().add(gpu3); gpuDao.getGpuList().add(gpu4);
	  gpuDao.getGpuList().add(gpu5); gpuDao.getGpuList().add(gpu6);
	  gpuDao.getGpuList().add(gpu7); gpuDao.getGpuList().add(gpu8);
	  gpuDao.getGpuList().add(gpu9);
	  
	  
	  
	  File fout = new File("src/dataSource/Gpu.Xml"); m.marshal(gpuDao,fout);
	  
	  Unmarshaller unm = ctx.createUnmarshaller(); GpuDao gpuNewDao = (GpuDao)
	  unm.unmarshal(fout);
	  
	  return gpuNewDao.getGpuList();
	  
	  } 
	 
}