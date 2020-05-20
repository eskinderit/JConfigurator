package guiDemo;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Component;
import dataSource.ComponentDao;
import shopDataManagement.ComponentDataManagement;
import shopDataManagement.DataManagement;

public class ShopDemoGui {

	public static void main(String[] args) throws JAXBException {
		Boolean relaunch;
		Scanner operation = new Scanner(System.in);
		do {
			relaunch = false;


			String inputOp;

			do {
				System.out.println("Quale operazione vuoi effettuare?");
				System.out.println("A) Aggiungere una componente   B) Rimuovere una componente   C) Reset lista di default");

				inputOp = operation.nextLine();

			}while(!(inputOp.contains("a") || inputOp.contains("b") || inputOp.contains("c")));



			String inputComp;
			do {
				if(inputOp.contains("a"))
					System.out.println("Quale tipo di componente desideri aggiungere? ");
				else if(inputOp.contains("b"))
					System.out.println("Quale tipo di componente desideri rimuovere? ");
				else 
					System.out.println("Di quale lista di componenti vuoi fare il reset? ");
				System.out.println("A) Cpu   B) Gpu   C) Motherboard   D) Case   E) Ram   F) Storage   G) Psu");

				inputComp = operation.nextLine();

			}while(!(inputComp.contains("a") || inputComp.contains("b") || inputComp.contains("c") || inputComp.contains("d") || inputComp.contains("e") || inputComp.contains("f") || inputComp.contains("g")));

			ComponentDao<?, ?> cdao;
			cdao = ComponentDataManagement.ComponentData(inputComp);
			DataManagement d = new DataManagement();

			if(inputOp.contains("b")) {

				String inputRem;

				int index;

				do {
					System.out.println("Seleziona la componente che vuoi rimuovere: ");

					int ind = 0;
					for(Component c:cdao.readComponents()) {
						System.out.println(ind+") "+c);
						ind++;
					}
					inputRem = operation.nextLine();
					if(StringUtils.isNumeric(inputRem)) {
						index = Integer.parseInt(inputRem);
						if(index<0 || index > cdao.readComponents().size())
							System.out.println("Input errato");
						else {

							d.deletec(index, inputComp);
						}
					}
					else 
						index=-1;

				}while(!StringUtils.isNumeric(inputRem) || (index<0 || index>cdao.readComponents().size()));

			}



			else if(inputOp.contains("a"))
				d.addc(inputComp, operation);

			else
				d.resetc(inputComp);


			int ind = 0;
			for(Component c:cdao.readComponents()) {
				System.out.println(ind+") "+c);
				ind++;
			}

			String launch;
			do {
				System.out.println("Desideri effettuare un'altra operazione? ");
				System.out.println("A) Si   B) No");
				launch = operation.nextLine();
			}while(!(launch.contains("a") || launch.contains("b")));

			if(launch.contains("a"))
				relaunch = true;


		}while(relaunch);
		operation.close();

	}
}


