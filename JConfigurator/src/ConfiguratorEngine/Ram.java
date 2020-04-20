package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ram extends Component {
	private String ramType;
	private int dimension;
	
	
	
	public Ram() {
		super();
	}
	public String getRamType() {
		return ramType;
	}
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	@Override
	public String toString() {
		return "Ram [name=" + name + ", price=" + price + ", power=" + power + ", ramType=" + ramType + ", dimension="
				+ dimension + "]";
	}
	
}
