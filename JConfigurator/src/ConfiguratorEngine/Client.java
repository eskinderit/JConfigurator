package ConfiguratorEngine;
import java.util.ArrayList;
import javax.xml.bind.*;
import dataSource.*;


public class Client {

	public static void main(String[] args) throws JAXBException {
		
	//GPU	

		  //Test Set
		  
		  GpuDao gpuDao1 = new GpuDao();
		  ArrayList<Gpu> defaultGpuList = gpuDao1.setDefaultComponents();
		  System.out.println("\n Lista resettata: \n");
		  defaultGpuList.forEach(System.out::println);
		  
			
			  //Test Add
			  
		   
		  	ArrayList<Gpu> gpuList = new ArrayList<>(); 
		  	Gpu g1 = new Gpu("Prova Inserimento 1", 3, 4, 5); 
		  	Gpu g2 = new Gpu("Prova Inserimento 2", 0, 1, 2); 
		  	gpuList.add(g1); 
		  	gpuList.add(g2);
		  	System.out.println("\n Lista modificata (inserimento): \n"); 
		  	GpuDao gpuDao2 = new GpuDao(); 
		  	ArrayList<Gpu> newList = gpuDao2.addComponents(gpuList);
		  newList.forEach(System.out::println);

			  
			  //Test Remove
			  
		  	GpuDao gpuDao3 = new GpuDao(); 
		  	System.out.println("\n Lista modificata (remove): \n"); int a[] = new int[2];
		  	a[0]=10; a[1]=1; ArrayList<Gpu> newList1 = gpuDao3.deleteComponents(a);
		  	newList1.forEach(System.out::println);
			  
			  //Test Read
		      GpuDao gpuDao4 = new GpuDao();
			  ArrayList<Gpu> actualList = gpuDao4.readComponents();
			  System.out.println("Lista attuale: \n");
			  actualList.forEach(System.out::println);
			  
			  //MOTHERBOARD
			  
			  //Test Set
			  MotherboardDao moboDao1 = new MotherboardDao();
			  ArrayList<Motherboard> defaultMotherboardList =
			  moboDao1.setDefaultComponents();
			  System.out.println("\n Lista resettata: \n");
			  defaultMotherboardList.forEach(System.out::println);
			  
			  //Test Add
			  
			  ArrayList<Motherboard> moboList = new ArrayList<>(); Motherboard m1 = new
			  Motherboard("Prova Inserimento 1", 3, 4, "prova","simula","LGA1151",true, 3 ); 
			  Motherboard m2 = new Motherboard("Prova Inserimento 2", 0, 1, "prova2",
			  "simula2", "LGA1151", false, 4); moboList.add(m1); moboList.add(m2);
			  System.out.println("\n Lista modificata (inserimento): \n");
			  MotherboardDao moboDao2 = new MotherboardDao();
			  ArrayList<Motherboard> newList2 = moboDao2.addComponents(moboList);
			  newList2.forEach(System.out::println);
			  
			  //Test Remove
			  
			  System.out.println("\n Lista modificata (remove): \n"); 
			  int b[] = new int[2];
			  b[0]=5; 
			  b[1]=1; 
			  MotherboardDao moboDao3 = new MotherboardDao();
			  ArrayList<Motherboard> newList3 = moboDao3.deleteComponents(b); newList3.forEach(System.out::println);
			  
			  //Test Read
			  
			  
			  MotherboardDao moboDao4 = new MotherboardDao();
			  ArrayList<Motherboard> readMotherboardList =moboDao4.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readMotherboardList.forEach(System.out::println);
			  
			  //Test Read
			  
			  
			  CpuDao cpuDao1 = new CpuDao();
			  ArrayList<Cpu> readCpuList =cpuDao1.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readCpuList.forEach(System.out::println);
			  
			  RamDao rDao1 = new RamDao();
			  ArrayList<Ram> readRamList =rDao1.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readRamList.forEach(System.out::println);
			  
			  StorageDao StorageDao1 = new StorageDao();
			  ArrayList<Storage> readStorageList =StorageDao1.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readStorageList.forEach(System.out::println);
			  
			  CaseDao CaseDao1 = new CaseDao();
			  ArrayList<Case> readCaseList =CaseDao1.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readCaseList.forEach(System.out::println);
			  
			  PsuDao PsuDao1 = new PsuDao();
			  ArrayList<Psu> readPsuList =PsuDao1.readComponents();
			  System.out.println("\n Lista attuale: \n");
			  readPsuList.forEach(System.out::println);
			  
			 
	}


}
