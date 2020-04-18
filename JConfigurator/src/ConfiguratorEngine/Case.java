package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Case extends Component {
	private int size;
	
	public Case(String name, int price, int power,int size) {
		super(name,price,power);
		this.size = size;
	}
	
	public Case() {
		super();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Case [name=" + getName() + ", price=" + getPrice() + ", power=" + getPower() +  
				  ", size=" + getSize()+"]";
	}
	
	
	
}
