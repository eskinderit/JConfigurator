package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfig;

public interface ComponentCheck  {

	public  <T extends Component> ArrayList<T> getCompatibleComponents(FullConfig f1) throws JAXBException;
	
}
