package configuratorEngine;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name", "price", "power", "oc", "socket" })
public class Cpu extends Component {
	private int power;
	private String socket;
	private boolean oc;

	public Cpu(String name, int price, int power, String socket, boolean oc) {
		super(name, price);
		this.socket = socket;
		this.oc = oc;
		this.power = power;
	}

	public Cpu() {
		super();
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (oc ? 1231 : 1237);
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
		Cpu other = (Cpu) obj;
		if (oc != other.oc)
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		return true;
	}

}
