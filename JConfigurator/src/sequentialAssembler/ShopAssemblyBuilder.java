package sequentialAssembler;

public class ShopAssemblyBuilder implements AssemblySequenceBuilder {

	@Override
	public AssemblyComposition buildAssemblySequence() {
		AssemblyComposition myComposition = new AssemblyComposition();

		myComposition.getCpuAssembly().setNextPassage1(myComposition.getGpuAssembly());
		myComposition.getGpuAssembly().setPreviousPassage1(myComposition.getCpuAssembly());

		return myComposition;

	}

}
