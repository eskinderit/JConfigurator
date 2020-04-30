package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Psu extends Component {

	public Psu() {
		super();
	}

	public Psu(String name, int price, int power) {
		super(name, price, power);
	}

	@Override
	public String toString() {
		return "Psu [name=" + getName() + ", power=" + getPower() + ", price=" + getPrice()	+ "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


}
