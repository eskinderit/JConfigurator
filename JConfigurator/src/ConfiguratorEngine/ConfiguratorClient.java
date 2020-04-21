package ConfiguratorEngine;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

import configurationController.CustomerController;
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
		
		CustomerController controller=new CustomerController();
		CpuDao cpuList = new CpuDao();
		cpuList.setDefaultComponents();
		
		for(Cpu c:cpuList.readComponents())
			System.out.println(c);
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		int c;
		String s;
		
		do{
			System.out.println("Select cpu: ");
			s=input.nextLine();
			c=Integer.parseInt(s);
		}while(c>=cpuList.readComponents().size());
		
		Cpu cpu=cpuList.readComponents().get(c);
		controller.getFullConfig().setMyCpu(cpu);
		
		//	GPU
		
		GpuDao gpuList=new GpuDao();
		gpuList.setDefaultComponents();
		
		for(Gpu g:gpuList.readComponents()) {
			System.out.println(g);
		}
		int g;
		
		do {
			System.out.println("Select Gpu: ");
			s=input.nextLine();
			g=Integer.parseInt(s);
		}while(g>=gpuList.readComponents().size());
		
		Gpu gpu=gpuList.readComponents().get(g);
		controller.getFullConfig().setMyGpu(gpu);
		
		//	MOTHERBOARD
		
		MotherboardDao motherboardList = new MotherboardDao();
		ArrayList<Motherboard> ml = new ArrayList<Motherboard>();
		motherboardList.setDefaultComponents();
		
		//	Check
		
		ml=controller.checkMotherboard(motherboardList);
		
		for(Motherboard m:ml)
			System.out.println(m);
		
		int m;
		
		do {
			System.out.println("Select Motherboard: ");
			s=input.nextLine();
			m=Integer.parseInt(s);
		}while(m>=motherboardList.readComponents().size());
		
		Motherboard motherboard=ml.get(m);
		controller.getFullConfig().setMyMotherboard(motherboard);
		
		//	RAM
				
		RamDao ramList=new RamDao();
		ramList.setDefaultComponents();
		ArrayList<Ram> rl = new ArrayList<Ram>();
		
		//	Check
		
		rl=controller.checkRam(ramList);
		
		for(Ram r:rl)
			System.out.println(r);
		
		int r;
		
		do {
			System.out.println("Select Ram");
			s=input.nextLine();
			r=Integer.parseInt(s);
		}while(r>=rl.size());
		
		Ram ram=rl.get(r);
		controller.getFullConfig().setMyRam(ram);
		
		//	CASE
		
		CaseDao caseList = new CaseDao();
		ArrayList<Case> cl = new ArrayList<Case>();
		caseList.setDefaultComponents();
		
		//	Check
		
		cl=controller.checkCase(caseList);
		
		for(Case cs:cl)
			System.out.println(cs);
		
		int cs;
		
		do {
			System.out.println("Select Case: ");
			s=input.nextLine();
			cs=Integer.parseInt(s);
		}while(cs>=cl.size());
		
		Case case1 = cl.get(cs);
		controller.getFullConfig().setMyCase1(case1);
		
		//STORAGE
		
		StorageDao storageList=new StorageDao();
		storageList.setDefaultComponents();
		
		for(Storage str:storageList.readComponents())
			System.out.println(str);
		
		int str;
		
		do {
			System.out.println("Select storage: ");
			s=input.nextLine();
			str=Integer.parseInt(s);
		}while(str>=storageList.readComponents().size());
		
		Storage storage = storageList.readComponents().get(str);
		controller.getFullConfig().setMyStorage(storage);
		
		//	PSU
		
		PsuDao psuList = new PsuDao();
		ArrayList<Psu> pl = new ArrayList<Psu>();
		psuList.setDefaultComponents();
		
		//	Check	
		
		pl=controller.checkPsu(psuList);
		
		for(Psu p:pl)
			System.out.println(p);
		
		int p;
		
		do {
			System.out.println("Select Psu: ");
			s=input.nextLine();
			p=Integer.parseInt(s);
		}while(p>=pl.size());
		
		Psu psu = pl.get(p);
		controller.getFullConfig().setMyPsu(psu);
		
		System.out.println(controller.getFullConfig());
		
	}

}
