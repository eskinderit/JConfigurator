package ConfiguratorEngine;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

import dataSource.CaseDao;
import dataSource.CpuDao;
import dataSource.GpuDao;
import dataSource.MotherboardDao;
import dataSource.PsuDao;
import dataSource.RamDao;
import dataSource.StorageDao;

public class ConfiguratorClient {

	public static void main(String[] args) throws JAXBException {
		
		//	CPU
		
		Controller controller=new Controller();
		CpuDao cpuList = new CpuDao();
		cpuList.setDefaultComponents();
		
		for(Cpu c:cpuList.readComponents())
			System.out.println(c);
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("Select cpu: ");
		String s=input.nextLine();
		int c=Integer.parseInt(s);
		Cpu cpu=cpuList.readComponents().get(c);
		
		controller.getFullConfig().setMyCpu(cpu);
		
		//	GPU
		
		GpuDao gpuList=new GpuDao();
		gpuList.setDefaultComponents();
		for(Gpu g:gpuList.readComponents()) {
			System.out.println(g);
		}
		System.out.println("Select Gpu: ");
		s=input.nextLine();
		int g=Integer.parseInt(s);
		Gpu gpu=gpuList.readComponents().get(g);
		controller.getFullConfig().setMyGpu(gpu);
		
		//	MOTHERBOARD
		
		MotherboardDao motherboardList = new MotherboardDao();
		ArrayList<Motherboard> ml = new ArrayList<Motherboard>();
		motherboardList.setDefaultComponents();
		
		//	Check
		ml=controller.checkMotherboard(motherboardList);
		
		System.out.println("Select Motherboard: ");
		for(Motherboard m:ml)
			System.out.println(m);
		
		s=input.nextLine();
		int m=Integer.parseInt(s);
		Motherboard motherboard=ml.get(m);
		controller.getFullConfig().setMyMotherboard(motherboard);
		System.out.println("Motherboard selected: "+motherboard);
		
		//	RAM
				
		RamDao ramList=new RamDao();
		ramList.setDefaultComponents();
		ArrayList<Ram> rl = new ArrayList<Ram>();
		//	Check
		rl=controller.checkRam(ramList);
		for(Ram r:rl)
			System.out.println(r);
		System.out.println("Select Ram");
		s=input.nextLine();
		int r=Integer.parseInt(s);
		Ram ram=rl.get(r);
		System.out.println("Ram Selected: "+ram);
		controller.getFullConfig().setMyRam(ram);
		
		//	CASE
		
		CaseDao caseList = new CaseDao();
		ArrayList<Case> cl = new ArrayList<Case>();
		caseList.setDefaultComponents();
		
		//	Check
		cl=controller.checkCase(caseList);
		for(Case cs:cl)
			System.out.println(cs);
		System.out.println("Select Case: ");
		s=input.nextLine();
		int cs=Integer.parseInt(s);
		Case case1 = cl.get(cs);
		System.out.println("Case selected: "+case1);
		controller.getFullConfig().setMyCase1(case1);
		
		//STORAGE
		StorageDao storageList=new StorageDao();
		storageList.setDefaultComponents();
		for(Storage str:storageList.readComponents())
			System.out.println(str);
		System.out.println("Select storage: ");
		s=input.nextLine();
		int str=Integer.parseInt(s);
		Storage storage = storageList.readComponents().get(str);
		controller.getFullConfig().setMyStorage(storage);
		System.out.println("Storage Selected: "+storage);
		
		System.out.println("Total power: "+controller.totalPower());
		
		//	PSU
		PsuDao psuList = new PsuDao();
		ArrayList<Psu> pl = new ArrayList<Psu>();
		psuList.setDefaultComponents();
		
		//	Check	
		
		pl=controller.checkPsu(psuList);
		for(Psu p:pl)
			System.out.println(p);
		System.out.println("Select Psu: ");
		s=input.nextLine();
		int p=Integer.parseInt(s);
		Psu psu = pl.get(p);
		controller.getFullConfig().setMyPsu(psu);
		
		System.out.println(controller.getFullConfig());
	}

}
