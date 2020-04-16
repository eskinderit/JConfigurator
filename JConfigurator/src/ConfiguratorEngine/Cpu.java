package ConfiguratorEngine;

public class Cpu extends Component{
	String socket;
	boolean oc;
	
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
	
}
