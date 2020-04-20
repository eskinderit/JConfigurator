package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Storage extends Component{
	private int capacity;
	private boolean ssd;
	
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
		return "Storage [name=" + name + ", price=" + price + ", power=" + power + ", capacity=" + capacity + ", ssd="
				+ ssd + "]";
	}
	
	
}
