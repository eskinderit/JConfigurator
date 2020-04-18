package ConfiguratorEngine;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="ram")
public class Ram extends Component {
	private String ramType;
	private int dimension;
	
	public Ram(String name, int price, int power, String ramType, int dimension) {
		super(name, price, power);
		this.ramType = ramType;
		this.dimension = dimension;
	}
	
	
	
	public Ram() {
		super();
	}



	@XmlElement
	public String getRamType() {
		return ramType;
	}
	
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	@XmlElement
	public int getDimension() {
		return dimension;
	}
	
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	@Override
	public String toString() {
		return "Ram [Name=" + getName() + ", Price=" + getPrice() + ", Power=" + getPower() + ", RamType="
				+ ramType + ", Dimension=" + dimension + "]";
	}
	
	
}
