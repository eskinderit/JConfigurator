package dataSource;

import ConfiguratorEngine.Motherboard;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MotherboardDao {
	 
	@XmlElement(name="Motherboard")
		ArrayList<Motherboard> motherboardList;
	

	public MotherboardDao() {
		this.motherboardList = new ArrayList<Motherboard>();
	}


	public ArrayList<Motherboard> getMotherboardList() {
		return motherboardList;
	}


	public void setMotherboardList(ArrayList<Motherboard> motherboardList) {
		this.motherboardList = motherboardList;
	}

	//TODO fare deleteComponents
	
	public static ArrayList<Motherboard> readComponents() throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(MotherboardDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Motherboard.Xml";
		  File fout = new File(s);
		  MotherboardDao motherboardNew = (MotherboardDao)unm.unmarshal(fout); 		  
		  ArrayList<Motherboard> motherboardList1 = motherboardNew.getMotherboardList(); 		  
		  return motherboardList1;
		
	}


	public static  ArrayList<Motherboard> addComponents(ArrayList<Motherboard> componentListToAdd) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(MotherboardDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Motherboard.Xml";
		  File fout = new File(s);
		  MotherboardDao motherboardDao = (MotherboardDao)unm.unmarshal(fout); 		   		  
		  
		  //Adding
		  
		  motherboardDao.getMotherboardList().addAll(componentListToAdd);
		  
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE); 
		  m.marshal(motherboardDao,fout);
	  
		return motherboardDao.getMotherboardList();
	}
	
	
	public static ArrayList<Motherboard> resetDefaultComponents() throws JAXBException {

		  JAXBContext ctx = JAXBContext.newInstance(MotherboardDao.class);
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  
		  
		  Motherboard a1 = new Motherboard("MSI Basem (lga 1151 DDR3)", 66, 10, "LGA1151", "H110", "DDR3", false, 3); 
		  Motherboard a2 = new Motherboard("Asus prime h270 plus (lga1151 DDR4)", 108, 10, "LGA1151", "H270", "DDR4", false, 3); 
		  Motherboard a3 = new Motherboard("MSI b350m (AM4 DDR4)", 89, 10, "AM4", "b350m", "DDR4", true, 3); 
		  Motherboard a4 = new Motherboard("Asus TUF z270 (lga 1151 DDR4)", 161, 10, "LGA1151", "Z270", "DDR4", true, 3); 
		  Motherboard a5 = new Motherboard("Gigabyte ga-z270 (lga 1151 DDR4)", 132, 10, "LGA1151", "Z270", "DDR4", true, 3); 
		  Motherboard a6 = new Motherboard("Gigabyte ga-ab359m-g3 (AM4 DDR4)", 96, 10, "AM4", "ab359m", "DDR4", true, 3);
		  Motherboard a7 = new Motherboard("Asus Crosshair VI Hero (AM4 DDR4)", 254, 10, "AM4", "X370", "DDR4", true, 3); 
		  Motherboard a8 = new Motherboard("Asus TUF X299 (AM4 DDR4)", 270, 10, "LGA2066", "X299", "DDR4", true, 3); 
		  Motherboard a9 = new Motherboard("Asus Rampage V Extreme (lga 2011 DDR4)", 400, 10, "LGA2011", "X99", "DDR4", true, 3);
		  Motherboard a10 = new Motherboard("ASUS H110I-PLUS (LGA1151 DDR4)", 73, 10, "LGA1151", "H110", "DDR4", false, 1);
		  
		  MotherboardDao aDao = new MotherboardDao();
		 
		  aDao.getMotherboardList().add(a1); 
		  aDao.getMotherboardList().add(a2);
		  aDao.getMotherboardList().add(a3);
		  aDao.getMotherboardList().add(a4);
		  aDao.getMotherboardList().add(a5);
		  aDao.getMotherboardList().add(a6);
		  aDao.getMotherboardList().add(a7);
		  aDao.getMotherboardList().add(a8);
		  aDao.getMotherboardList().add(a9);
		  aDao.getMotherboardList().add(a10);
		 
		  
		  
		  File fout = new File("src/dataSource/MotherboardDemo.Xml");
		  m.marshal(aDao,fout);
		  
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  MotherboardDao motherboardNewDao = (MotherboardDao) unm.unmarshal(fout);
		  
		  return motherboardNewDao.getMotherboardList();
		  		 
	}


}
