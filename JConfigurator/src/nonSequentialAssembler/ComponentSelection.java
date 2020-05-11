package nonSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfigBuilder;

public interface ComponentSelection {
	
	public  <T extends Component> ArrayList<T> getCompatibleComponents(FullConfigBuilder f) throws JAXBException;
	public int getSize() throws JAXBException;
}
