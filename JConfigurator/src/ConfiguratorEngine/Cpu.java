package ConfiguratorEngine;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="cpu")
public class Cpu extends Component{
	private String socket;
	private boolean oc;
	
	
	public Cpu(String name, int price, int power, String socket, boolean oc) {
		super(name, price, power);
		this.socket = socket;
		this.oc = oc;
	}
	
	
	public Cpu() {
		super();
	}

	@XmlElement
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	@XmlElement
	public boolean isOc() {
		return oc;
	}
	public void setOc(boolean oc) {
		this.oc = oc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (oc ? 1231 : 1237);
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
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


	@Override
	public String toString() {
		return "Cpu [Name=" + getName() + ", Price=" + getPrice() + ", Power=" + getPower() + ", Socket=" + socket
				+ ",oc=" + oc + "]";
	}

	
}
