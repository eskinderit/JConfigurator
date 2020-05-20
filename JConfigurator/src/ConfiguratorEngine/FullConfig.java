package ConfiguratorEngine;

public class FullConfig {

	private Psu psu;
	private Gpu gpu;
	private Motherboard motherboard;
	private Cpu cpu;
	private Case case0;
	private Storage storage;
	private Ram ram;
	private ComputerShop computerShop;

	private int psuOverhead = 50;

	public FullConfig() {
	}

	public Psu getPsu() {
		return psu;
	}

	public void setPsu(Psu psu) {
		this.psu = psu;
	}

	public Gpu getGpu() {
		return gpu;
	}

	public void setGpu(Gpu gpu) {
		this.gpu = gpu;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Case getCase0() {
		return case0;
	}

	public void setCase0(Case case0) {
		this.case0 = case0;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public ComputerShop getComputerShop() {
		return computerShop;
	}

	public void setComputerShop(ComputerShop computerShop) {
		this.computerShop = computerShop;
	}

	public int getPsuOverhead() {
		return this.psuOverhead;
	}

	public void setPsuOverhead(int psuOverhead) {
		this.psuOverhead = psuOverhead;
	}

	public int getSubtotalPower() {
		int allPower = 0;
		allPower += this.getCpu().getPower();
		allPower += this.getGpu().getPower();
		allPower += this.getMotherboard().getPower();
		allPower += this.getRam().getPower();
		allPower += this.getCase0().getPower();
		allPower += this.getStorage().getPower();

		return allPower;
	}

	public int getTotalPrice() {
		int allPrice = 0;
		allPrice += this.getCpu().getPrice();
		allPrice += this.getGpu().getPrice();
		allPrice += this.getMotherboard().getPrice();
		allPrice += this.getRam().getPrice();
		allPrice += this.getCase0().getPrice();
		allPrice += this.getStorage().getPrice();
		allPrice += this.getPsu().getPrice();
		return allPrice;
	}

	@Override
	public String toString() {
		return "FullConfig : \n myCpu =" + this.getCpu() + "\n myGpu =" + this.getGpu() + "\n myMotherboard ="
				+ this.getMotherboard() + "\n myRam =" + this.getRam() + "\n myCase1 =" + this.getCase0()
				+ "\n myStorage =" + this.getStorage() + "\n myPsu=" + this.getPsu() + "\n myComputerShop ="
				+ this.getComputerShop();
	}

	public int getTotalEstimatedPower() {
		int total = this.getSubtotalPower();
		return total += this.psuOverhead;
	}

}
