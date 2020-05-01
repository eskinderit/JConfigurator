package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Case extends Component {
	private int size;
	private int power;
	
	public Case(String name, int price, int power,int size) {
		super(name,price);
		this.size = size;
		this.power=power;
	}
	
	public Case() {
		super();
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
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
		Case other = (Case) obj;
		if (size != other.size)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Case [name=" + getName() + ", price=" + getPrice() + ", power=" + getPower() +  
				  ", size=" + getSize()+"]";
	}
	
}
