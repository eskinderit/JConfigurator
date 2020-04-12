package ConfiguratorEngine;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		  List<Gpu> gpu = Gpu.readComponentsFromCSV("src/Database/Gpu.csv");
		  
		  //let's print all the person read from CSV file 
		 for (Gpu b : gpu) {
		  System.out.println(b);}

	}
}
