package dataSource;

import java.io.File;
import java.util.ArrayList;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import ConfiguratorEngine.Component;

import javax.xml.bind.annotation.*;

@XmlTransient
public abstract class ComponentDao <T1 extends Component, T2 extends ComponentDao<T1,T2>>{


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
	
	public abstract ArrayList<T1> deleteComponents(ArrayList<T1> toDeleteList) throws JAXBException;
	
	public abstract ArrayList<T1> addComponents(ArrayList<T1> toAddList) throws JAXBException;
	
	public abstract ArrayList<T1> setDefaultComponents() throws JAXBException;
	
	public abstract ArrayList<T1> setEmptyComponents() throws JAXBException;

	 protected  ArrayList<T1> _readComponents(String myFile, Class<T2> class2Bound) throws JAXBException {
		  
		JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();
		  File fout = new File(myFile);
		  T2 newComponent = class2Bound.cast(unm.unmarshal(fout)); 		  
		  ArrayList<T1> co = newComponent.getComponentList(); 		  
		  return co;
		
	}
	
	 protected  ArrayList<T1> _removeComponents(ArrayList<T1> toDeleteList, String myFile, Class<T2> class2Bound) throws JAXBException {
		  

		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller(); 
		  File fout =new File(myFile);
		  T2 componentDao = class2Bound.cast(unm.unmarshal(fout)); 
		  
		 
		  ArrayList<T1> componentDaoList = componentDao.getComponentList();
		  componentDaoList.removeAll(toDeleteList);
		  componentDao.setComponentList(componentDaoList);
		  

		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }
	 
	 protected  ArrayList<T1> _addComponents(String myFile, ArrayList<T1> componentListToAdd, Class<T2> class2Bound) throws JAXBException {
		  
		  
		  JAXBContext ctx = JAXBContext.newInstance(class2Bound); 
		  Unmarshaller unm = ctx.createUnmarshaller();  
		  File fout = new File(myFile);
		  T2 componentDao = class2Bound.cast(unm.unmarshal(fout));
		  
		  
		  ArrayList<T1> componentDaoList = componentDao.getComponentList();
		  componentDaoList.addAll(componentListToAdd);
		  componentDao.setComponentList(componentDaoList);
		  
		  
		  
		  Marshaller m = ctx.createMarshaller();
		  m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		  m.marshal(componentDao,fout);
		  
		  return componentDao.getComponentList(); }

	 protected  ArrayList<T1> _setDefaultComponents(String sourceFile, String destinationFile, Class<T2> class2Bound) throws JAXBException {
		
		JAXBContext context=JAXBContext.newInstance(class2Bound);
		Unmarshaller ums=context.createUnmarshaller();
		T2 componentDao =class2Bound.cast(ums.unmarshal(new File(sourceFile)));
		
		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(componentDao, new File(destinationFile));
		
		return componentDao.getComponentList();
	}
}
