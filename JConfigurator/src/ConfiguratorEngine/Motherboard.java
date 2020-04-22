package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Motherboard extends Component {
	private String socket;
	private String chipset;
	private String ramType;
	private boolean oc;
	private int size;
	
	public Motherboard(String name, int price, int power, String socket, String chipset, String ramType, boolean oc, int size) {
		super(name, price, power);
		this.socket=socket;
		this.chipset=chipset;
		this.socket=socket;
		this.ramType=ramType;
		this.oc=oc;
		this.size=size;
	}

	@SuppressWarnings("unused")
	private Motherboard() {
		super();
	}


	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getRamType() {
		return ramType;
	}
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	public boolean isOc() {
		return oc;
	}
	public void setOc(boolean oc) {
		this.oc = oc;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Motherboard [name=" +name +", price=" +price +", power=" +power +", socket=" + socket + ", chipset=" + chipset + ", ramType=" + ramType + ", oc=" + oc
				+ ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chipset == null) ? 0 : chipset.hashCode());
		result = prime * result + (oc ? 1231 : 1237);
		result = prime * result + ((ramType == null) ? 0 : ramType.hashCode());
		result = prime * result + size;
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
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
		Motherboard other = (Motherboard) obj;
		if (chipset == null) {
			if (other.chipset != null)
				return false;
		} else if (!chipset.equals(other.chipset))
			return false;
		if (oc != other.oc)
			return false;
		if (ramType == null) {
			if (other.ramType != null)
				return false;
		} else if (!ramType.equals(other.ramType))
			return false;
		if (size != other.size)
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		return true;
	}

	
	
}
