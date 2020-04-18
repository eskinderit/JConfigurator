package ConfiguratorEngine;
import javax.xml.bind.*;


import dataSource.CpuDao;
import dataSource.GpuDao;
import dataSource.RamDao;
import dataSource.StorageDao;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) throws JAXBException {
		
		
	//Test readGpus - legge le gpu presenti in lista
		ArrayList<Gpu> actualList = GpuDao.readGpus();
		System.out.println("Lista attuale: \n");
		for (Gpu g: actualList)
			System.out.println(g);
	//Test addGpus - aggiunge una collection di gpu a quelle gia presenti
		ArrayList<Gpu> gpuList = new ArrayList<>();
		Gpu g1 = new Gpu("Prova Inserimento 1", 3, 4, 5); 
		Gpu g2 = new Gpu("Prova Inserimento 2", 0, 1, 2);
		gpuList.add(g1);
		gpuList.add(g2);
		System.out.println("\n Lista modificata: \n");
		ArrayList<Gpu> newList = GpuDao.addGpus(gpuList);
		for (Gpu a: newList)
			System.out.println(a);
	//Test resetDefaultGpus - riscrive le Gpu di default

		ArrayList<Gpu> defaultList = GpuDao.resetDefaultGpus();
		System.out.println("\n Lista resettata: \n");
		for (Gpu b: defaultList)
			System.out.println(b);
		
		
		
		
		// CPU
		
		CpuDao cpu = new CpuDao();
		
		// Test setCpus: crea il file modificabile delle cpu
		
		cpu.setCpuFile();
		
		System.out.println("\n\nLista Cpu settata:");
		for(Cpu c:cpu.readCpus()) {
			System.out.println(c);
		}
		
		// Test AddCpus: creo un arrayList di Cpu da aggiungere al file modificabile
		
		ArrayList<Cpu> cpusToAdd = new ArrayList<Cpu>();
		
		Cpu cpu1 = new Cpu("Intel Pentium G4520 (lga 1151)AAA", 95, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("Intel Core i5 7400 (lga 1151)AAA", 178, 10, "LGA1151", false);
		Cpu cpu3 = new Cpu("AMD Ryzen 5 1400 (AM4)AAA", 176, 10, "AM4", true);
		
		cpusToAdd.add(cpu1);
		cpusToAdd.add(cpu2);
		cpusToAdd.add(cpu3);
		
		cpu.addCpus(cpusToAdd);
		
		System.out.println("\n\nLista Cpu con aggiunte:");
		for(Cpu c:cpu.readCpus()) {
			System.out.println(c);
		}
		
		//	Remove
		
		int cpusToRemove[]= {0, 1};
		
		cpu.removeCpus(cpusToRemove);
		
		System.out.println("\n\nLista Cpu con rimozioni:");
		for(Cpu c:cpu.readCpus()) {
			System.out.println(c);
		}
		
		
		// Reset
		
		cpu.setDefaultCpuFile();
		System.out.println("\n\nLista Cpu resettata:");
		for(Cpu c:cpu.readCpus()) {
			System.out.println(c);
		}
		
		
		
		// RAM

		RamDao ram = new RamDao();

		// Test setRams: crea il file modificabile delle Ram

		ram.setRamFile();

		System.out.println("\n\nLista Ram settata:");
		for(Ram r:ram.readRams()) {
			System.out.println(r);
		}

		// Test AddRams: creo un arrayList di Ram da aggiungere al file modificabile

		ArrayList<Ram> ramsToAdd = new ArrayList<Ram>();

		Ram ram1=new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2=new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR3", 8);
		Ram ram3=new Ram("Corsair Dominator Platinum DDR4 (4x8)", 318, 10, "DDR4", 32);

		ramsToAdd.add(ram1);
		ramsToAdd.add(ram2);
		ramsToAdd.add(ram3);

		ram.addRams(ramsToAdd);

		System.out.println("\n\nLista Ram con aggiunte:");
		for(Ram r:ram.readRams()) {
			System.out.println(r);
		}

		//	Remove

		int RamsToRemove[]= {0, 1};

		ram.removeRams(RamsToRemove);

		System.out.println("\n\nLista Ram con rimozioni:");
		for(Ram r:ram.readRams()) {
			System.out.println(r);
		}


		// Reset

		ram.setDefaultRamFile();
		System.out.println("\n\nLista Ram resettata:");
		for(Ram r:ram.readRams()) {
			System.out.println(r);
		}
		
		// STORAGE

		StorageDao storage = new StorageDao();

		// Test setStorages: crea il file modificabile delle Storage

		storage.setStorageFile();

		System.out.println("\n\nLista Storage settata:");
		for(Storage s:storage.readStorages()) {
			System.out.println(s);
		}

		// Test AddStorages: creo un arrayList di Storage da aggiungere al file modificabile

		ArrayList<Storage> storagesToAdd = new ArrayList<Storage>();

		Storage storage1 = new Storage("WD Blue 1TB (HDD)", 49, 10, 1000, false);
		Storage storage2 = new Storage("Samsung 850 evo 500GB (SSD)", 153, 10, 500, true);
		Storage storage3 = new Storage("Samsung 850 evo 250GB (SSD)", 153, 10, 250, true);

		storagesToAdd.add(storage1);
		storagesToAdd.add(storage2);
		storagesToAdd.add(storage3);

		storage.addStorages(storagesToAdd);

		System.out.println("\n\nLista Storage con aggiunte:");
		for(Storage s:storage.readStorages()) {
			System.out.println(s);
		}

		//	Remove

		int storagesToRemove[]= {0, 1};

		storage.removeStorages(storagesToRemove);

		System.out.println("\n\nLista Storage con rimozioni:");
		for(Storage s:storage.readStorages()) {
			System.out.println(s);
		}

		// Reset

		storage.setDefaultStorageFile();
		System.out.println("\n\nLista Storage resettata:");
		for(Storage s:storage.readStorages()) {
			System.out.println(s);
		}

		
	}

}
