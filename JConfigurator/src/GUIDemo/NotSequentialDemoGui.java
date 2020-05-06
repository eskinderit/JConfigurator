package GUIDemo;

import java.util.Scanner;
import javax.xml.bind.JAXBException;

import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.FullConfigBuilder;
import notSequentialAssembler.SelectCase;
import notSequentialAssembler.SelectCpu;
import notSequentialAssembler.SelectGpu;
import notSequentialAssembler.SelectMotherboard;
import notSequentialAssembler.SelectPsu;
import notSequentialAssembler.SelectRam;
import notSequentialAssembler.SelectStorage;


public class NotSequentialDemoGui {

	public static void main(String[] args) throws JAXBException {

		Scanner input=new Scanner(System.in);		
		String s;
		int index;
		FullConfigBuilder fullConfigBuilder = FullConfigBuilder.getIstance();


		do {
			System.out.println("Type a component name to select it: ");
			s=input.nextLine();
			if(s.contentEquals("cpu")) {
				SelectCpu selectCpu = new SelectCpu();
				selectCpu.getCompatibleComponents(fullConfigBuilder);
				index = Integer.parseInt(input.nextLine());
				selectCpu.selectComp(index, fullConfigBuilder);
			}
			else if(s.contentEquals("gpu")) {
				SelectGpu selectGpu = new SelectGpu();
				selectGpu.readComponent();
				index = Integer.parseInt(input.nextLine());
				selectGpu.selectComp(index, fullConfigBuilder);
			}
			else if(s.contentEquals("motherboard")) {
				SelectMotherboard selectMotherboard = new SelectMotherboard();
				selectMotherboard.getCompatibleComponents(fullConfigBuilder);
				index = Integer.parseInt(input.nextLine());
				selectMotherboard.selectComp(index, fullConfigBuilder);
			}
			else if(s.contentEquals("case")) {
				SelectCase selectCase = new SelectCase();
				selectCase.getCompatibleComponents(fullConfigBuilder);
				index = Integer.parseInt(input.nextLine());
				selectCase.selectComp(index, fullConfigBuilder);
			}
			else if(s.contentEquals("ram")) {
				SelectRam selectRam = new SelectRam();
				selectRam.getCompatibleComponents(fullConfigBuilder);
				index = Integer.parseInt(input.nextLine());
				selectRam.selectComp(index, fullConfigBuilder);
			}
			else if(s.contentEquals("storage")) {
				SelectStorage selectStorage = new SelectStorage();
				selectStorage.readComponent();
				index = Integer.parseInt(input.nextLine());
				selectStorage.selectComp(index, fullConfigBuilder);
			}
		}while(!fullConfigBuilder.isComplete());
		
		SelectPsu selectPsu = new SelectPsu();
		selectPsu.getCompatibleComponents(fullConfigBuilder);
		index = Integer.parseInt(input.nextLine());
		selectPsu.selectComp(index, fullConfigBuilder);

		FullConfig configuration = fullConfigBuilder.buildFullConfig();

		System.out.println("Complete configuration:\n" + configuration);

		input.close();

	}
}
