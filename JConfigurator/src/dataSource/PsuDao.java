package dataSource;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import ConfiguratorEngine.Psu;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PsuDao {

	@XmlElement(name="Motherboard")
	ArrayList<Psu> psuList;


    public PsuDao() {
	   this.psuList = new ArrayList<Psu>();
}

	
	public ArrayList<Psu> getPsuList() {
	return psuList;
}


	public void setPsuList(ArrayList<Psu> psuList) {
	this.psuList = psuList;
}

	//TODO fare deleteComponents
	public static ArrayList<Psu> readComponents() throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(PsuDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Psu.Xml";
		  File fout = new File(s);
		  PsuDao psuNew = (PsuDao)unm.unmarshal(fout); 		  
		  ArrayList<Psu> psuList1 = psuNew.getPsuList(); 		  
		  return psuList1;
		
	}
	
	
	public static  ArrayList<Psu> addComponents(ArrayList<Psu> psuListToAdd) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(PsuDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Psu.Xml";
		  File fout = new File(s);
		  PsuDao psuDao = (PsuDao)unm.unmarshal(fout); 		   		  
		  
		  //Adding
		  
		  psuDao.getPsuList().addAll(psuListToAdd);
		  
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE); 
		  m.marshal(psuDao,fout);
	  
		return psuDao.getPsuList();
	}
	
	
	public static ArrayList<Psu> resetDefaultComponents() throws JAXBException {

		  JAXBContext ctx = JAXBContext.newInstance(PsuDao.class);
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  
		  
		  Psu a1 = new Psu("XFX XTR 550W", 85, 550); 
		  Psu a2 = new Psu("XFX P1 750W", 116, 750); 
		  Psu a3 = new Psu("EVGA 430 W", 48, 430); 
		  Psu a4 = new Psu("Corsair HX1200i", 280, 1200); 
		  Psu a5 = new Psu("Antec VP400", 38, 400); 
		  Psu a6 = new Psu("Seasonic 520II-520", 49, 520);
		  Psu a7 = new Psu("XFX 550TS", 88, 550); 
		  Psu a8 = new Psu("EVGA SUPERNOVA", 157, 750); 

		  
		  PsuDao aDao = new PsuDao();
		 
		  aDao.getPsuList().add(a1); 
		  aDao.getPsuList().add(a2);
		  aDao.getPsuList().add(a3);
		  aDao.getPsuList().add(a4);
		  aDao.getPsuList().add(a5);
		  aDao.getPsuList().add(a6);
		  aDao.getPsuList().add(a7);
		  aDao.getPsuList().add(a8);

		 
		  
		  
		  File fout = new File("src/dataSource/PsuDemo.Xml");
		  m.marshal(aDao,fout);
		  
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  PsuDao psuNewDao = (PsuDao) unm.unmarshal(fout);
		  
		  return psuNewDao.getPsuList();
		  		 
	}
}
