package ConfiguratorEngine;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"name","price","address"})
public class ComputerShop extends Component{

	private String address;
	
	
	public ComputerShop() {
		super();
	}
	

	public ComputerShop(String name, int price, String address) {
		super(name, price);
		this.address = address;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		ComputerShop other = (ComputerShop) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ComputerShop [name=" + name + ", price=" + price + ", address=" + address + "]";
	}
	
	
	


}
