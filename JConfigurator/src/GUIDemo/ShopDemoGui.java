package GUIDemo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import dataSource.ComponentDao;
import shopDataManagement.ComponentDataManagement;
import shopDataManagement.DataManagement;

public class ShopDemoGui {

	public static void main(String[] args) throws JAXBException {


		Scanner operation = new Scanner(System.in);
		String inputOp;

		do {
			System.out.println("Quale operazione vuoi effettuare?");
			System.out.println("A) Aggiungere una componente   B) Rimuovere una componente");

			inputOp = operation.nextLine();

		}while(!(inputOp.contains("a") || inputOp.contains("b")));

		Scanner component = new Scanner(System.in);
		String inputComp;
		do {
			if(inputOp.contains("a"))
				System.out.println("Quale tipo di componente desideri aggiungere? ");
			else
				System.out.println("Quale tipo di componente desideri rimuovere? ");
			System.out.println("A) Cpu   B) Gpu   C) Motherboard   D) Case   E) Ram   F) Storage   G) Psu");

			inputComp = component.nextLine();

		}while(!(inputComp.contains("a") || inputComp.contains("b") || inputComp.contains("c") || inputComp.contains("d") || inputComp.contains("e") || inputComp.contains("f") || inputComp.contains("g")));


		if(inputOp.contains("b")) {
			Scanner remover = new Scanner(System.in);
			String inputRem;
			ComponentDao<?, ?> cdao;

			do {
				System.out.println("Seleziona la componente che vuoi rimuovere: ");
				cdao = ComponentDataManagement.ComponentData(inputComp);
				int index = 0;
				for(Component c:cdao.readComponents()) {
					System.out.println(index+") "+c);
					index++;
				}
				inputRem = remover.nextLine();

			}while(!StringUtils.isNumeric(inputRem));

			int index = Integer.parseInt(inputRem);
			if(index<0 || index > cdao.readComponents().size())
				System.out.println("Input errato");
			else {
				DataManagement d = new DataManagement();
				d.deletec(index, inputComp);
				index = 0;
				for(Component c:cdao.readComponents()) {
					System.out.println(index+") "+c);
					index++;
				}
			}

			remover.close();

		}


	}
}


