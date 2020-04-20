package ConfiguratorEngine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cpu extends Component{
	private String socket;
	private boolean oc;
	
	
	
	public Cpu() {
		super();
	}

	public Cpu(String name, int price, int power, String socket, boolean oc) {
		super(name, price, power);
		this.socket = socket;
		this.oc = oc;
	}
	
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public boolean isOc() {
		return oc;
	}
	public void setOc(boolean oc) {
		this.oc = oc;
	}

	@Override
	public String toString() {
		return "Cpu [name=" + name + ", price=" + price + ", power=" + power + ", socket=" + socket + ", oc=" + oc
				+ "]";
	}
	
	
	
	
	
}
