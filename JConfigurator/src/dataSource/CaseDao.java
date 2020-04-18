package dataSource;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import ConfiguratorEngine.Case;




@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CaseDao {

	@XmlElement(name="Motherboard")
	ArrayList<Case> caseList;


    public CaseDao() {
	   this.caseList = new ArrayList<Case>();
}

    

	public ArrayList<Case> getCaseList() {
		return caseList;
	}



	public void setCaseList(ArrayList<Case> caseList) {
		this.caseList = caseList;
	}

//TODO fare deleteComponents
	public static ArrayList<Case> readComponents() throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(CaseDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Case.Xml";
		  File fout = new File(s);
		  CaseDao caseNew = (CaseDao)unm.unmarshal(fout); 		  
		  ArrayList<Case> caseList1 = caseNew.getCaseList(); 		  
		  return caseList1;
		
	}
	
	public static  ArrayList<Case> addComponents(ArrayList<Case> caseListToAdd) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(CaseDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Case.Xml";
		  File fout = new File(s);
		  CaseDao caseDao = (CaseDao)unm.unmarshal(fout); 		   		  
		  
		  //Adding
		  
		  caseDao.getCaseList().addAll(caseListToAdd);
		  
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE); 
		  m.marshal(caseDao,fout);
	  
		return caseDao.getCaseList();
	}
	
	public static  ArrayList<Case> removeComponents(int componentListToDelete[]) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(GpuDao.class); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  String s = "src/dataSource/Gpu.Xml";
		  File fout = new File(s);
		  CaseDao gpusInUseDao = (CaseDao)unm.unmarshal(fout); 		   		  
		  //Subtracting
		  
		  for (int i : componentListToDelete)
			
				   gpusInUseDao.getCaseList().remove(gpusInUseDao.getCaseList().get(i));
			  
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE); 
		  m.marshal(gpusInUseDao,fout);
	  
		return gpusInUseDao.getCaseList();
	}
	
	public static ArrayList<Case> resetDefaultComponents() throws JAXBException {

		  JAXBContext ctx = JAXBContext.newInstance(CaseDao.class);
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  
		  
		  Case a1 = new Case("Corsair Spec 01 (ATX)", 56, 10, 3); 
		  Case a2 = new Case("Thermaltake Core V1 (MINI-ITX)", 44, 10, 1); 
		  Case a3 = new Case("Corsair Carbide Air 540 (ATX)", 149, 10, 3); 
		  Case a4 = new Case("NZXT s340 (ATX)", 78, 10, 3); 
		  Case a5 = new Case("NZXT H440 (ATX)", 170, 10, 3); 
		  Case a6 = new Case("Corsair Obsidian 750D (ATX)", 156, 10, 3);


		  
		  CaseDao aDao = new CaseDao();
		 
		  aDao.getCaseList().add(a1); 
		  aDao.getCaseList().add(a2);
		  aDao.getCaseList().add(a3);
		  aDao.getCaseList().add(a4);
		  aDao.getCaseList().add(a5);
		  aDao.getCaseList().add(a6);


		 
		  
		  
		  File fout = new File("src/dataSource/CaseDemo.Xml");
		  m.marshal(aDao,fout);
		  
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  CaseDao caseNewDao = (CaseDao) unm.unmarshal(fout);
		  
		  return caseNewDao.getCaseList();
		  		 
	}
}
