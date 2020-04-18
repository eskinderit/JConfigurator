package ConfiguratorEngine;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Gpu extends Component {

private int memory;

public Gpu(String name, int price, int power, int memory) {
super(name, price, power);
this.memory = memory;
}


public Gpu() {
	super();
}


public int getMemory() {
	return memory;
}


public void setMemory(int memory) {
	this.memory = memory;
}



  @Override public String toString() { return "Gpu [name=" + this.getName() +
  ", price=" + this.getPrice() + ", power=" + this.getPower() +
  ", memory="+this.getMemory()+"]"; }
  


}
