package ConfiguratorEngine;

public class Storage extends Component{
	private int capacity;
	private boolean ssd;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isSsd() {
		return ssd;
	}
	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}
	
}
