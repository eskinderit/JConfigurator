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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dimension;
		result = prime * result + ((ramType == null) ? 0 : ramType.hashCode());
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
		Ram other = (Ram) obj;
		if (dimension != other.dimension)
			return false;
		if (ramType == null) {
			if (other.ramType != null)
				return false;
		} else if (!ramType.equals(other.ramType))
			return false;
		return true;
	}
	
	
	
}
