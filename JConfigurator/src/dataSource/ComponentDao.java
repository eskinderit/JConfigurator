package dataSource;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

import configuratorEngine.Component;

@XmlTransient
public abstract class ComponentDao<T1 extends Component, T2 extends ComponentDao<T1, T2>> {

	protected ArrayList<T1> componentList;

	public ComponentDao() {
		this.componentList = new ArrayList<T1>();
	}

	/**
	 * getter used by the JAXB Marshaller
	 */
	protected abstract ArrayList<T1> getComponentList();

	/**
	 * setter used by the JAXB Marshaller
	 */
	protected abstract void setComponentList(ArrayList<T1> componentList);

	/**
	 * Should read a list of the components managed by the Dao from somewhere
	 * 
	 * @return the list of readed components
	 * @throws JAXBException Exception from the marshalling/unmarshalling of Xmls
	 */
	public abstract ArrayList<T1> readComponents() throws JAXBException;

	/**
	 * Should delete a list of components from the list in use by client
	 * 
	 * @param toDeleteList list of components to be deleted
	 * @return the obtained list after delete
	 * @throws JAXBException Exception from the marshalling/unmarshalling of Xmls
	 */
	public abstract ArrayList<T1> deleteComponents(ArrayList<T1> toDeleteList) throws JAXBException;

	/**
	 * Should add a list of components to the list in use by client
	 * 
	 * @param toAddList list of components to be added
	 * @return the obtained list after add
	 * @throws JAXBException Exception from the marshalling/unmarshalling of Xmls
	 */
	public abstract ArrayList<T1> addComponents(ArrayList<T1> toAddList) throws JAXBException;

	/**
	 * Should reset the list in use by client to default components
	 * 
	 * @return the obtained list after reset
	 * @throws JAXBException Exception from the marshalling/unmarshalling of Xmls
	 */
	public abstract ArrayList<T1> setDefaultComponents() throws JAXBException;

	/**
	 * Should empty the list in use by client
	 * 
	 * @return the obtained blank list
	 * @throws JAXBException Exception from the marshalling/unmarshalling of Xmls
	 */
	public abstract ArrayList<T1> setEmptyComponents() throws JAXBException;

	/**
	 * Uses JAXB to read components from an Xml
	 * 
	 * @param myFile      Address of the Xml file from which the components are read
	 * @param class2Bound The kind of class that the Xml represents (It is the
	 *                    target class)
	 * @return The list of read components
	 * @throws JAXBException
	 */
	final protected ArrayList<T1> _readComponents(String myFile, Class<T2> class2Bound) throws JAXBException {

		JAXBContext ctx = JAXBContext.newInstance(class2Bound);
		Unmarshaller unm = ctx.createUnmarshaller();
		File fout = new File(myFile);
		T2 newComponent = class2Bound.cast(unm.unmarshal(fout));
		ArrayList<T1> co = newComponent.getComponentList();
		return co;

	}

	/**
	 * Uses JAXB to remove components from an Xml
	 * 
	 * @param toDeleteList list of the components to be deleted from the Xml
	 * @param myFile       Address of the Xml file from which the components are
	 *                     deleted
	 * @param class2Bound  The kind of class that the Xml represents (It is the
	 *                     target class)
	 * @return The updated list of components (after remove)
	 * @throws JAXBException
	 */
	final protected ArrayList<T1> _removeComponents(ArrayList<T1> toDeleteList, String myFile, Class<T2> class2Bound)
			throws JAXBException {

		JAXBContext ctx = JAXBContext.newInstance(class2Bound);
		Unmarshaller unm = ctx.createUnmarshaller();
		File fout = new File(myFile);
		T2 componentDao = class2Bound.cast(unm.unmarshal(fout));

		ArrayList<T1> componentDaoList = componentDao.getComponentList();
		componentDaoList.removeAll(toDeleteList);
		componentDao.setComponentList(componentDaoList);

		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(componentDao, fout);

		return componentDao.getComponentList();
	}

	/**
	 * Uses JAXB to add components from an Xml
	 * 
	 * @param myFile             Address of the Xml file to which components are
	 *                           added
	 * @param componentListToAdd The list of components to be added
	 * @param class2Bound        The kind of class that the Xml represents (It is
	 *                           the target class)
	 * @return The updated list of components (after add)
	 * @throws JAXBException
	 */
	final protected ArrayList<T1> _addComponents(String myFile, ArrayList<T1> componentListToAdd, Class<T2> class2Bound)
			throws JAXBException {

		JAXBContext ctx = JAXBContext.newInstance(class2Bound);
		Unmarshaller unm = ctx.createUnmarshaller();
		File fout = new File(myFile);
		T2 componentDao = class2Bound.cast(unm.unmarshal(fout));

		if (componentDao.getComponentList() != null) {
			ArrayList<T1> newComponentList = componentDao.getComponentList();

			for (T1 component : componentListToAdd) {
				int i = 0;
				for (T1 element : componentDao.getComponentList()) {
					if (component.equals(element))
						i = 1;
				}
				if (i == 0)
					newComponentList.add(component);
			}
			componentDao.setComponentList(newComponentList);
		} else
			componentDao.setComponentList(componentListToAdd);

		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(componentDao, fout);

		return componentDao.getComponentList();
	}

	/**
	 * @param sourceFile      Address of the Xml file to be copied
	 * @param destinationFile The Xml file to be replaced
	 * @param class2Bound     The kind of class that the Xml represents (It is the
	 *                        target class)
	 * @return The updated list of components(after the replacement)
	 * @throws JAXBException
	 */
	final protected ArrayList<T1> _setDefaultComponents(String sourceFile, String destinationFile,
			Class<T2> class2Bound) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(class2Bound);
		Unmarshaller ums = context.createUnmarshaller();
		T2 componentDao = class2Bound.cast(ums.unmarshal(new File(sourceFile)));

		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(componentDao, new File(destinationFile));

		return componentDao.getComponentList();
	}

	public T1 getComponent(int i) throws JAXBException {
		return readComponents().get(i);
	};

}
