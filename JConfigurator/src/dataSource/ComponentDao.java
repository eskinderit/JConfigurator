package dataSource;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import ConfiguratorEngine.Component;

abstract public class ComponentDao {
	
    @XmlElementWrapper(name="GPUs")
    @XmlElement(name="GPU")
	ArrayList<Component> componentList;
	
}
