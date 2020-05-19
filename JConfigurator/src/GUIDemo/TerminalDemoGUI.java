package GUIDemo;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfig;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.CpuAssembly;

public class TerminalDemoGUI {

	public static void main(String[] args) throws JAXBException {

		ComponentAssembly<?> assemblyStep = new CpuAssembly();

		FullConfig f1 = new FullConfig();

		System.out.println("##################### CONFIGURATION STARTED #####################");

		Scanner input = new Scanner(System.in);
		String s;
		while (assemblyStep != null) {

			if (assemblyStep.getComponentDao() != null) {
				System.out.println(
						"##### Scrivi il numero del componente + invio oppure 'back' se vuoi retrocedere al passo precedente #####\n");

				int index = 0;
				for (Component i : assemblyStep.getCompatibleComponents(f1)) {
					System.out.println(String.valueOf(index++) + ": " + i);
				}

			}
			// selezione componente indicato
			s = input.nextLine();
			assemblyStep.InputBasedBehavior(assemblyStep, f1, s);

			System.out.println(s);
			if ((assemblyStep.isRetry() == false) && (assemblyStep.isGoback() == false)) {
				assemblyStep = assemblyStep.getNextPassage();

			}

			else if ((assemblyStep.isGoback() == true) && (assemblyStep.isRetry() == false)) {
				assemblyStep = assemblyStep.getPreviousPassage();
			} else {
				System.out.println("########### Input errato! ########### \n");
			}
		}

		// costruisce l'oggetto fullConfig

		System.out.println("###### La configurazione scelta e' la seguente: ######\n" + f1);
		input.close();
		System.out.println("\n Prezzo Totale: " + f1.getTotalPrice() + " €" + "\n Consumo totale in full load: "
				+ f1.getTotalEstimatedPower() + " W");

	}

}
