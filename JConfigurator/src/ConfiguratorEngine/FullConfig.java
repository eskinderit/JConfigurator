package ConfiguratorEngine;

public class FullConfig {
	private Psu myPsu;
	private Gpu myGpu;
	private Motherboard myMotherboard;
	private Cpu myCpu;
	private Case myCase1;
	private Storage myStorage;
	private Ram myRam;
	private int totalPower;
	
	private static FullConfig istance=null;		// Singleton
	
	private FullConfig() {}
	
	public static FullConfig getIstance() {
		if(istance==null)
			istance=new FullConfig();
		return istance;
	}
	
	
	public Psu getMyPsu() {
		return myPsu;
	}
	public void setMyPsu(Psu myPsu) {
		this.myPsu = myPsu;
	}
	public Gpu getMyGpu() {
		return myGpu;
	}
	public void setMyGpu(Gpu myGpu) {
		this.myGpu = myGpu;
	}
	public Motherboard getMyMotherboard() {
		return myMotherboard;
	}
	public void setMyMotherboard(Motherboard myMotherboard) {
		this.myMotherboard = myMotherboard;
	}
	public Cpu getMyCpu() {
		return myCpu;
	}
	public void setMyCpu(Cpu myCpu) {
		this.myCpu = myCpu;
	}
	public Case getMyCase1() {
		return myCase1;
	}
	public void setMyCase1(Case myCase1) {
		this.myCase1 = myCase1;
	}
	public Storage getMyStorage() {
		return myStorage;
	}
	public void setMyStorage(Storage myStorage) {
		this.myStorage = myStorage;
	}
	public Ram getMyRam() {
		return myRam;
	}
	public void setMyRam(Ram myRam) {
		this.myRam = myRam;
	}
	
	public void setTotalPower(int power) {
		this.totalPower=power;
	}
	
	public int getTotalPower() {
		return this.totalPower;
	}
	
	@Override
	public String toString() {
		return "FullConfig \n[" +myPsu + ",\n" + myGpu + ",\n" + myMotherboard + "\n"
				+ myCpu + "\n" + myCase1 + "\n" + myStorage + ",\n" + myRam + "]";
	}
	
	
}
