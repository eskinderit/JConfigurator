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

	
	
}
