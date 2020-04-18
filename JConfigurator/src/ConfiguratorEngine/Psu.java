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


}
