package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name", "price", "power", "capacity", "ssd" })
public class Storage extends Component {

	private int capacity;
	private boolean ssd;
	private int power;

	public Storage() {
		super();
	}

	public Storage(String name, int price, int power, int capacity, boolean ssd) {
		super(name, price);
		this.capacity = capacity;
		this.ssd = ssd;
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + capacity;
		result = prime * result + (ssd ? 1231 : 1237);
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
		Storage other = (Storage) obj;
		if (capacity != other.capacity)
			return false;
		if (ssd != other.ssd)
			return false;
		return true;
	}

}
