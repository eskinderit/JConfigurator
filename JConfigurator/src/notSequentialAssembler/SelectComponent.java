package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfigBuilder;

public abstract class SelectComponent {
	
	public abstract void readComponent()throws JAXBException;
	public abstract void selectComp(int n, FullConfigBuilder f) throws JAXBException;
	abstract public  <T extends Component> ArrayList<T> getCompatibleComponents(FullConfigBuilder f) throws JAXBException;
}
