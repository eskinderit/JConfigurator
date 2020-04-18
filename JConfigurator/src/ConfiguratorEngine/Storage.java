package ConfiguratorEngine;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="storage")
public class Storage extends Component{
	int capacity;
	boolean ssd;
	
	public Storage(String name, int price, int power, int capacity, boolean ssd) {
		super(name, price, power);
		this.capacity = capacity;
		this.ssd = ssd;
	}
	
	public Storage() {
		super();
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isSsd() {
		return ssd;
	}
	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}
	@Override
	public String toString() {
		return "Storage [Name=" + getName() + ", Price=" + getPrice() + ", Power=" + getPower() + ", Capacity="
				+ capacity + ", Ssd" + ssd + "]";
	}
	
}
