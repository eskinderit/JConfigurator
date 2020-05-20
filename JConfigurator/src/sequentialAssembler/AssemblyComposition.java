package sequentialAssembler;

public class AssemblyComposition {

	private CpuAssembly cpuAssembly;
	private GpuAssembly gpuAssembly;
	private MotherboardAssembly motherboardAssembly;
	private CaseAssembly caseAssembly;
	private RamAssembly ramAssembly;
	private StorageAssembly storageAssembly;
	private ComputerShopAssembly shopAssembly;
	private PsuAssembly psuAssembly;

	public AssemblyComposition() {
		super();
		this.cpuAssembly = new CpuAssembly();
		this.gpuAssembly = new GpuAssembly();
		this.motherboardAssembly = new MotherboardAssembly();
		this.caseAssembly = new CaseAssembly();
		this.ramAssembly = new RamAssembly();
		this.storageAssembly = new StorageAssembly();
		this.shopAssembly = new ComputerShopAssembly();
		this.psuAssembly = new PsuAssembly();
	}

	public CpuAssembly getCpuAssembly() {
		return cpuAssembly;
	}

	public void setCpuAssembly(CpuAssembly cpuAssembly) {
		this.cpuAssembly = cpuAssembly;
	}

	public GpuAssembly getGpuAssembly() {
		return gpuAssembly;
	}

	public void setGpuAssembly(GpuAssembly gpuAssembly) {
		this.gpuAssembly = gpuAssembly;
	}

	public MotherboardAssembly getMotherboardAssembly() {
		return motherboardAssembly;
	}

	public void setMotherboardAssembly(MotherboardAssembly motherboardAssembly) {
		this.motherboardAssembly = motherboardAssembly;
	}

	public CaseAssembly getCaseAssembly() {
		return caseAssembly;
	}

	public void setCaseAssembly(CaseAssembly caseAssembly) {
		this.caseAssembly = caseAssembly;
	}

	public RamAssembly getRamAssembly() {
		return ramAssembly;
	}

	public void setRamAssembly(RamAssembly ramAssembly) {
		this.ramAssembly = ramAssembly;
	}

	public StorageAssembly getStorageAssembly() {
		return storageAssembly;
	}

	public void setStorageAssembly(StorageAssembly storageAssembly) {
		this.storageAssembly = storageAssembly;
	}

	public ComputerShopAssembly getShopAssembly() {
		return shopAssembly;
	}

	public void ComputerShopAssembly(ComputerShopAssembly shopAssembly) {
		this.shopAssembly = shopAssembly;
	}

	public PsuAssembly getPsuAssembly() {
		return psuAssembly;
	}

	public void setPsuAssembly(PsuAssembly psuAssembly) {
		this.psuAssembly = psuAssembly;
	}

}
