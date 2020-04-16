package ConfiguratorEngine;
import javax.xml.bind.*;
import dataSource.GpuDao;
import java.io.File;
import java.util.List;

public class Client {

	public static void main(String[] args) throws JAXBException {
		
		//Pezzo di codice per leggere e scrivere gli xml
		
		  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); 
		  Marshaller m = ctx.createMarshaller(); 
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
		    

				  
		  m.marshal(gpuDao,System.out); File fout = new File("Gpu.Xml");
		  m.marshal(gpuDao,fout);
		  
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  GpuDao gpuNew = (GpuDao)unm.unmarshal(fout); 
		  
		  List<Gpu> gpuList = gpuNew.getGpuList(); 
		  
		  for (Gpu g: gpuList)
			  System.out.println(g);
		 
		

	}


}
