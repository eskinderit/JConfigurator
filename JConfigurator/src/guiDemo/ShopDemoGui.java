package guiDemo;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Component;
import dataSource.ComponentDao;
import shopDataManagement.CaseDataManagement;
import shopDataManagement.ComponentDataManagement;
import shopDataManagement.CpuDataManagement;
import shopDataManagement.GpuDataManagement;
import shopDataManagement.MotherboardDataManagement;
import shopDataManagement.PsuDataManagement;
import shopDataManagement.RamDataManagement;
import shopDataManagement.StorageDataManagement;

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

			ComponentDao<?, ?> compDao;
			ComponentDataManagement<?> com;
			
			if(inputComp.contains("a")) {
				com = new CpuDataManagement();
				compDao = com.getComponentDao();
			}
			else if(inputComp.contains("b")) {
				com = new GpuDataManagement();
				compDao = com.getComponentDao();
			}
			else if(inputComp.contains("c")) {
				com = new MotherboardDataManagement();
				compDao = com.getComponentDao();
			}
			else if(inputComp.contains("d")) {
				com = new CaseDataManagement();
				compDao = com.getComponentDao();
			}
			else if(inputComp.contains("e")) {
				com = new RamDataManagement();
				compDao = com.getComponentDao();
			}
			else if(inputComp.contains("f")) {
				com = new StorageDataManagement();
				compDao = com.getComponentDao();
			}
			else {
				com= new PsuDataManagement();
				compDao = com.getComponentDao();
			}
			

			if(inputOp.contains("b")) {

				String inputRem;

				int index;

				do {
					System.out.println("Seleziona la componente che vuoi rimuovere: ");

					int ind = 0;
					for(Component c:compDao.readComponents()) {
						System.out.println(ind+") "+c);
						ind++;
					}
					inputRem = operation.nextLine();
					if(StringUtils.isNumeric(inputRem)) {
						index = Integer.parseInt(inputRem);
						if(index<0 || index > compDao.readComponents().size())
							System.out.println("Input errato");
						else {

							com.deleteComp(index);
						}
					}
					else 
						index=-1;

				}while(!StringUtils.isNumeric(inputRem) || (index<0 || index>compDao.readComponents().size()));

			}



			else if(inputOp.contains("a"))
				com.addComp(operation);

			else
				com.resetComp();


			int ind = 0;
			for(Component c:compDao.readComponents()) {
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


