package ConfiguratorEngine;

public class ComputerShop {
	private String name;
	private String address;
	private int FixedCommissionCost;
	private int percentageCommissionCost;


	public ComputerShop() {
		this.name="";
	    this.address="";
	    this.FixedCommissionCost=0;
	    this.percentageCommissionCost=0;
	}


	public ComputerShop(String name, String address, int fixedCommissionCost, int percentageCommissionCost) {
		super();
		this.name = name;
		this.address = address;
		FixedCommissionCost = fixedCommissionCost;
		this.percentageCommissionCost = percentageCommissionCost;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getFixedCommissionCost() {
		return FixedCommissionCost;
	}


	public void setFixedCommissionCost(int fixedCommissionCost) {
		FixedCommissionCost = fixedCommissionCost;
	}


	public int getPercentageCommissionCost() {
		return percentageCommissionCost;
	}


	public void setPercentageCommissionCost(int percentageCommissionCost) {
		this.percentageCommissionCost = percentageCommissionCost;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FixedCommissionCost;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + percentageCommissionCost;
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
		ComputerShop other = (ComputerShop) obj;
		if (FixedCommissionCost != other.FixedCommissionCost)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percentageCommissionCost != other.percentageCommissionCost)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ComputerShop [name=" + name + ", address=" + address + ", FixedCommissionCost=" + FixedCommissionCost
				+ ", percentageCommissionCost=" + percentageCommissionCost + "]";
	}
	
	

	
	

}
