package guiDemo;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import configuratorEngine.Component;
import configuratorEngine.FullConfig;
import sequentialAssembler.ArtisanAssemblyBuilder;
import sequentialAssembler.AssemblyComposition;
import sequentialAssembler.AssemblySequenceBuilder;
import sequentialAssembler.ComponentAssembly;
import sequentialAssembler.ShopAssemblyBuilder;

public class UserGui {

	public static void main(String[] args) throws JAXBException {

		Scanner input = new Scanner(System.in);
		String s;
		AssemblySequenceBuilder builder;

		do {
			System.out.println(
					"##################### Benvenuto in JConfigurator! #####################\n \n scrivi 'custom' se vuoi assemblare il pc da solo oppure scrivi 'shop' se invece vuoi che il pc sia montato da dei professionisti");
			s = input.nextLine();
		} while (!(s.equals("custom") || s.equals("shop")));

		if (s.contentEquals("shop")) {
			builder = new ShopAssemblyBuilder();
		} else {
			builder = new ArtisanAssemblyBuilder();
		}

		AssemblyComposition composizione = builder.buildAssemblySequence();
		ComponentAssembly<?> assemblyStep = composizione.getCpuAssembly();
		FullConfig f1 = new FullConfig();

		System.out.println("##################### CONFIGURATION STARTED #####################");

		while (assemblyStep != null) {

			assemblyStep.setRetry(false);
			assemblyStep.setGoback(false);

			if (assemblyStep != null) {
				System.out.println(
						"##### Scrivi il numero del componente + invio oppure 'back' se vuoi retrocedere al passo precedente #####\n");

				int index = 0;
				for (Component i : assemblyStep.getCompatibleComponents(f1)) {
					System.out.println(String.valueOf(index++) + ": " + i);
				}

			}
			// selezione componente indicato
			s = input.nextLine();
			assemblyStep.InputBasedBehavior(f1, s);

			System.out.println(s);
			if ((assemblyStep.isRetry() == false) && (assemblyStep.isGoback() == false)) {
				assemblyStep = assemblyStep.getNextPassage1();

			}

			else if ((assemblyStep.isGoback() == true) && (assemblyStep.isRetry() == false)) {
				if (assemblyStep.getPreviousPassage1() != null)
					assemblyStep = assemblyStep.getPreviousPassage1();
			} else {
				System.out.println("########### Input errato! ########### \n");
			}
		}

		// costruisce l'oggetto fullConfig

		System.out.println("###### La configurazione scelta e' la seguente: ######\n" + f1);
		input.close();
		System.out.println("\n Prezzo Totale: " + f1.getTotalPrice() + " €" + "\n Consumo totale in full load: "
				+ f1.getTotalEstimatedPower() + " W" + "\n scarto aggiuntivo di potenza compreso nel calcolo: "
				+ f1.getPsuOverhead() + " W");

	}

}
