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
public abstract class ComponentDao <T1 extends Component>{


	protected ArrayList<T1> componentList;
	
	
	
	
	public ComponentDao() {
		this.componentList = new ArrayList<T1>();
	}



	public ArrayList<T1> getComponentList() {
		return componentList;
	}

	public void setComponentList(ArrayList<T1> componentList) {
		this.componentList = componentList;
	}


	public abstract ArrayList<T1> readComponents() throws JAXBException;
	
	public abstract ArrayList<T1> deleteComponents(int toDeleteList[]) throws JAXBException;
	
	public abstract ArrayList<T1> addComponents(ArrayList<T1> toAddList) throws JAXBException;
	
	public abstract ArrayList<T1> setDefaultComponents() throws JAXBException;

	 protected <T2 extends ComponentDao<T1>> ArrayList<T1> _readComponents(String myFile, Class<T2> class2Bound) throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  File fout = new File(myFile);
		  T2 newComponent = (T2)unm.unmarshal(fout); 		  
		  ArrayList<T1> co = newComponent.getComponentList(); 		  
		  return co;
		
	}
	
	 protected <T2 extends ComponentDao<T1>> ArrayList<T1> _removeComponents(int toDelete[], String myFile, Class<T2> class2Bound) throws JAXBException {
		  
		  Arrays.sort(toDelete);
		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  File fout =new File(myFile);
		  T2 componentDao = (T2)unm.unmarshal(fout); 
		  
		  for(int i=0; i<toDelete.length; i++) {
			  for (int j=0; j<componentDao.getComponentList().size(); j++)
			  if (toDelete[i]==j) {
				  componentDao.getComponentList().remove(j);
				  for (int k=i; k<toDelete.length;k++)
					  toDelete[k]=toDelete[k]-1;
			  }
		  }

		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }
	 
	 protected < T2 extends ComponentDao<T1>> ArrayList<T1> _addComponents(String myFile, ArrayList<T1> componentListToAdd, Class<T2> class2Bound) throws JAXBException {
		  
		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();  
		  File fout = new File(myFile);
		  T2 componentDao = (T2)unm.unmarshal(fout);
		  
		  
		  componentDao.getComponentList().addAll(componentListToAdd);
		  
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }

	 protected <T2 extends ComponentDao<T1>> ArrayList<T1> _setDefaultComponents(String sourceFile, String destinationFile, Class<T2> class2Bound) throws JAXBException {
		
		JAXBContext context=JAXBContext.newInstance(class2Bound);
		Unmarshaller ums=context.createUnmarshaller();
		T2 componentDao =(T2)ums.unmarshal(new File(sourceFile));
		
		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(componentDao, new File(destinationFile));
		
		return componentDao.getComponentList();
	}
}
