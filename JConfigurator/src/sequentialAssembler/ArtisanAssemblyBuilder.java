package sequentialAssembler;

public class ArtisanAssemblyBuilder implements AssemblySequenceBuilder {

	@Override
	public AssemblyComposition buildAssemblySequence() {
		AssemblyComposition myComposition = new AssemblyComposition();

		// set step 1: Cpu
		myComposition.getCpuAssembly().setNextPassage1(myComposition.getGpuAssembly());
		// set step 2: Gpu
		myComposition.getGpuAssembly().setPreviousPassage1(myComposition.getCpuAssembly());
		myComposition.getGpuAssembly().setNextPassage1(myComposition.getMotherboardAssembly());
		// set step 3: Motherboard
		myComposition.getMotherboardAssembly().setPreviousPassage1(myComposition.getGpuAssembly());
		myComposition.getMotherboardAssembly().setNextPassage1(myComposition.getRamAssembly());
		// set step 4: Ram
		myComposition.getRamAssembly().setPreviousPassage1(myComposition.getMotherboardAssembly());
		myComposition.getRamAssembly().setNextPassage1(myComposition.getCaseAssembly());
		// set step 5: Case
		myComposition.getCaseAssembly().setPreviousPassage1(myComposition.getRamAssembly());
		myComposition.getCaseAssembly().setNextPassage1(myComposition.getStorageAssembly());
		// set step 6: Storage
		myComposition.getStorageAssembly().setPreviousPassage1(myComposition.getCaseAssembly());
		myComposition.getStorageAssembly().setNextPassage1(myComposition.getPsuAssembly());
		// set step 7: Psu
		myComposition.getPsuAssembly().setPreviousPassage1(myComposition.getStorageAssembly());

		return myComposition;

	}

}
