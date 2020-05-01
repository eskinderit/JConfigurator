package ConfiguratorEngine;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Gpu extends Component {

private int memory;
private int power;

public Gpu(String name, int price, int power, int memory) {
super(name, price);
this.memory = memory;
this.power=power;
}


public int getPower() {
	return power;
}


public void setPower(int power) {
	this.power = power;
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


@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + memory;
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Gpu other = (Gpu) obj;
	if (memory != other.memory)
		return false;
	return true;
}
  
  
  


}
