package dataSource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import ConfiguratorEngine.Component;

import javax.xml.bind.annotation.*;

@XmlTransient
public abstract class ComponentDao{


	protected ArrayList<Component> componentList;
	
	
	
	
	public ComponentDao() {
		this.componentList = new ArrayList<Component>();
	}



	public ArrayList getComponentList() {
		return componentList;
	}




	public void setComponentList(ArrayList componentList) {
		this.componentList = componentList;
	}




	static public <T1 extends Component, T2 extends ComponentDao> ArrayList<T1> readComponents(String myFile, Class class2Bound) throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  File fout = new File(myFile);
		  T2 newComponent = (T2)unm.unmarshal(fout); 		  
		  ArrayList<T1> co = newComponent.getComponentList(); 		  
		  return co;
		
	}
	
	static public <T1 extends Component, T2 extends ComponentDao> ArrayList<T1> removeComponents(int toDelete[], String myFile, Class class2Bound) throws JAXBException {
		  
		  Arrays.sort(toDelete);
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  File fout =new File(myFile);
		  T2 componentDao = (T2)unm.unmarshal(fout); 
		  
		  //Deleting
		  for(int i=0; i<toDelete.length; i++) {
			  for (int j=0; j<componentDao.getComponentList().size(); j++)
			  if (toDelete[i]==j) {
				  componentDao.getComponentList().remove(j);
				  for (int k=i; k<toDelete.length;k++)
					  toDelete[k]=toDelete[k]-1;
			  }
		  }
		  //Rewriting
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }
	 
	static public <T1 extends Component, T2 extends ComponentDao> ArrayList<T1> addComponents(String myFile, ArrayList<T1> componentListToAdd, Class class2Bound) throws JAXBException {
		  
		  //Reading
		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();  
		  File fout = new File(myFile);
		  T2 componentDao = (T2)unm.unmarshal(fout);
		  
		  //Adding
		  
		  componentDao.getComponentList().addAll(componentListToAdd);
		  
		  //Overwrite
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }

    //TODO mancano set e reset
}
