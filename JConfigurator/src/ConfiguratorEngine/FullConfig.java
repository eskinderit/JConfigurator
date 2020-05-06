package ConfiguratorEngine;

public class FullConfig {
	private Psu myPsu;
	private Gpu myGpu;
	private Motherboard myMotherboard;
	private Cpu myCpu;
	private Case myCase1;
	private Storage myStorage;
	private Ram myRam;
	private int totalPower=0;
	
	public FullConfig(Cpu myCpu, Gpu myGpu, Motherboard myMotherboard, Ram myRam, Case myCase1, Storage myStorage, Psu myPsu, int totalPower) {
		this.myCpu=myCpu;
		this.myGpu=myGpu;
		this.myMotherboard=myMotherboard;
		this.myRam=myRam;
		this.myCase1=myCase1;
		this.myStorage=myStorage;
		this.myPsu=myPsu;
		this.totalPower=totalPower;
	}

	public Psu getMyPsu() {
		return myPsu;
	}

	public Gpu getMyGpu() {
		return myGpu;
	}

	public Motherboard getMyMotherboard() {
		return myMotherboard;
	}

	public Cpu getMyCpu() {
		return myCpu;
	}

	public Case getMyCase1() {
		return myCase1;
	}

	public Storage getMyStorage() {
		return myStorage;
	}

	public Ram getMyRam() {
		return myRam;
	}

	public int getTotalPower() {
		return totalPower;
	}

	@Override
	public String toString() {
		return "FullConfig [Psu=" + myPsu + ", \nGpu=" + myGpu + ", \nMotherboard=" + myMotherboard + ", \nCpu="
				+ myCpu + ", \nCase1=" + myCase1 + ", \nStorage=" + myStorage + ", \nRam=" + myRam + ", \ntotalPower="
				+ totalPower + "]";
	}
	
	
}

