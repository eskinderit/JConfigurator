package ConfiguratorEngine;

public class FullConfig {
	private Psu myPsu;
	private Gpu myGpu;
	private Motherboard myMotherboard;
	private Cpu myCpu;
	private Case myCase1;
	private Storage myStorage;
	private Ram myRam;
	private ComputerShop myComputerShop;
	private static int psuOverhead = 50;

	
	public int getPsuOverhead() {
		return psuOverhead;
	}

	public void setPsuOverhead(int psuOverhead) {
		FullConfig.psuOverhead = psuOverhead;
	}

	private static FullConfig instance=null;		// Singleton
	
	private FullConfig() {}
	
	public static FullConfig getIstance() {
		if(instance==null)
			instance=new FullConfig();
		return instance;
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
	

	public int getTotalEstimatedPower() {
		int allPower=0;
		allPower+=this.getMyCpu().getPower();
		allPower+=this.getMyGpu().getPower();
		allPower+=this.getMyMotherboard().getPower();
		allPower+=this.getMyRam().getPower();
		allPower+=this.getMyCase1().getPower();
		allPower+=this.getMyStorage().getPower();

		return allPower;
	}
	
	public int getTotalPrice() {
		int allPrice=0;
		allPrice+=this.getMyCpu().getPrice();
		allPrice+=this.getMyGpu().getPrice();
		allPrice+=this.getMyMotherboard().getPrice();
		allPrice+=this.getMyRam().getPrice();
		allPrice+=this.getMyCase1().getPrice();
		allPrice+=this.getMyStorage().getPrice();
		allPrice+=this.getMyPsu().getPrice();
		return allPrice;
	}
	
	public ComputerShop getMyComputerShop() {
		return myComputerShop;
	}

	public void setMyComputerShop(ComputerShop myComputerShop) {
		this.myComputerShop = myComputerShop;
	}




	
	@Override
	public String toString() {
		return "FullConfig : \n myCpu=" + myCpu + "\n myGpu=" + myGpu + "\n myMotherboard=" + myMotherboard + "\n myRam="
				+ myRam + "\n myCase1=" + myCase1 + "\n myStorage=" + myStorage + "\n myPsu=" + myPsu + "\n myComputerShop="
				+ myComputerShop;
	}

	static public boolean checkTotalWattagePsu(FullConfig f1, Psu psu ) {
		if(psu.getPower()-f1.getTotalEstimatedPower()>50)
			return true;
		else
			return false;
	}
	
	static public boolean checkMotherboardCase(Motherboard m1, Case c1) {
		if( c1.getSize()>=m1.getSize())
			return true;
		else
			return false;
	}
	
	static public boolean checkMotherboardRam(Motherboard m1, Ram r1) {
		if(r1.getRamType().contentEquals(m1.getRamType()))
				return true;
		else
			return false;
	}
	
	static public boolean checkMotherboardCpu(Cpu c1, Motherboard m1) {
		if(m1.getSocket().contentEquals(c1.getSocket()))
				return true;
		else
			return false;
	}
	
	
	
	
	
}
