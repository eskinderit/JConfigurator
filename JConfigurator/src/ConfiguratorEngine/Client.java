package ConfiguratorEngine;
import java.util.ArrayList;
import javax.xml.bind.*;
import dataSource.*;


public class Client {

	public static void main(String[] args) throws JAXBException {
		
		
		
		  //Test resetDefaultGpus - riscrive le Gpu di default
		  
		  ArrayList<Gpu> defaultGpuList = GpuDao.resetDefaultComponents();
		  System.out.println("\n Lista resettata: \n");
		  defaultGpuList.forEach(System.out::println);
		  
		  
		  //Test addGpus - aggiunge una collection di gpu a quelle gia presenti
		  
		  ArrayList<Gpu> gpuList = new ArrayList<>(); Gpu g1 = new
		  Gpu("Prova Inserimento 1", 3, 4, 5); Gpu g2 = new Gpu("Prova Inserimento 2",
		  0, 1, 2); gpuList.add(g1); gpuList.add(g2);
		  System.out.println("\n Lista modificata (inserimento) NEW: \n"); ArrayList<Gpu>
		  newList = GpuDao.nuovaAggiunta(gpuList);
		  newList.forEach(System.out::println);
		  
		  //Remove addGpus - rimuove una collection di gpu a quelle gia presenti
		  
		  ArrayList<Gpu> gpuRemoveList = new ArrayList<>(); Gpu g11 = new Gpu("Prova Inserimento 1", 3, 4, 5); 
		  gpuRemoveList.add(g11);
		  System.out.println("\n Lista modificata (remove) tricked: \n"); 
		  int a[] = new int[2];
		  a[0]=10;
		  a[1]=1;
		  ArrayList<Gpu> newList1 = GpuDao.nuovaRimozione(a);
		  newList1.forEach(System.out::println);
		  
		  //Test readGpus - legge le gpu presenti in lista
		 		
		ArrayList<Gpu> actualList = GpuDao.nuovaLettura();
		System.out.println("Lista attuale trick: \n");
		actualList.forEach(System.out::println);
	
		
	
		
		  //Test resetDefaultMotherboards - riscrive le Gpu di default
		  
		  ArrayList<Motherboard> defaultMotherboardList =
		  MotherboardDao.resetDefaultComponents();
		  System.out.println("\n Lista resettata: \n");
		  defaultMotherboardList.forEach(System.out::println);
		  
		  //Test resetDefaultPsus - riscrive le Gpu di default
		  
		  ArrayList<Psu> defaultPsuList = PsuDao.resetDefaultComponents();
		  System.out.println("\n Lista resettata: \n");
		  defaultPsuList.forEach(System.out::println);
		  
		  //Test resetDefaultPsus - riscrive le Gpu di default
		  
		  ArrayList<Case> defaultCaseList = CaseDao.resetDefaultComponents();
		  System.out.println("\n Lista resettata: \n");
		  defaultCaseList.forEach(System.out::println);
		 

	}


}
