package ConfiguratorEngine;
import javax.xml.bind.*;
import dataSource.GpuDao;
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
		

	}


}
