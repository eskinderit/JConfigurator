package GUIDemo;


import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfig;
import ConfiguratorEngine.FullConfigBuilder;
import ConfiguratorEngine.Gpu;
import ConfiguratorEngine.Motherboard;
import ConfiguratorEngine.Psu;
import dataSource.GpuDao;
import nonSequentialAssembler.CorrectComponentsSelection;
import nonSequentialAssembler.CpuSelection;
import nonSequentialAssembler.GpuSelection;

public class NonSequentialGUIDemo {

	public static void main(String[] args) throws JAXBException {
		Scanner input=new Scanner(System.in);
		String s;
		int index;
		FullConfigBuilder fullConfigBuilder = new FullConfigBuilder();
		CorrectComponentsSelection selectCorrectComponents = new CorrectComponentsSelection();	
		
		do {
			do {
				System.out.println("Which component do you like to select? ");
				System.out.println("A: Cpu;  B: Gpu;  C: motherboard;  D: Case;  E: Ram;  F:Storage");
				s=input.nextLine();
			}while(!selectCorrectComponents.checkInput(s));
			
			ArrayList<Component> a = selectCorrectComponents.createCorrectList(s, fullConfigBuilder);
			int i = 0;
			for(Component c : a) {
				System.out.println(i+ ") " +c);
				i++;
			}

			do {
				System.out.println("Select a component: ");
				
				index = Integer.parseInt(input.nextLine());
			}while(selectCorrectComponents.checkIndex(a, index, s, fullConfigBuilder)==false);

		}while(!fullConfigBuilder.isComplete());
		
		ArrayList<Psu> psuList = selectCorrectComponents.createPsuList(fullConfigBuilder);
		int i=0;
		for(Psu p:psuList) {
			System.out.println(i + ") " + p);
			i++;
		}
		do {
			System.out.println("\nSelect a Psu from list: ");
			index = Integer.parseInt(input.nextLine());
		}while(psuList.size()<index);
		
		fullConfigBuilder.psu(psuList.get(index));
		
		FullConfig f = fullConfigBuilder.buildFullConfig();
		System.out.println("Complete configuration: ");
		System.out.println(f);
		
		System.out.println("\n\nTotal power: " + f.getTotalPower());
		
		
		
		input.close();
	}

	

}
