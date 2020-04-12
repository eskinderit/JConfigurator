package ConfiguratorEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Gpu extends Component {

private int memory;

private Gpu(String name, int price, int power, int memory) {
super(name, price, power);
this.memory = memory;
}


public Gpu() {
	super();
}


public int getMemory() {
	return memory;
}


public void setMemory(int memory) {
	this.memory = memory;
}


public static  List<Gpu> readComponentsFromCSV(String fileName) 
{
    
	List<Gpu> componentList = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);

    System.out.println(pathToFile.toAbsolutePath());
    
    // create an instance of BufferedReader
    // using try with resource, Java 7 feature to close resources
    try (BufferedReader br = Files.newBufferedReader(pathToFile,
            StandardCharsets.US_ASCII)) {

        // read the first line from the text file
        String line = br.readLine();

        // loop until all lines are read
        while (line != null) {

            // use string.split to load a string array with the values from
            // each line of
            // the file, using a comma as the delimiter
            String[] attributes = line.split(",");

   
            Gpu gpu = new Gpu();
            Gpu component = gpu.createComponentFromString(attributes); 
            //TODO implementare createComponent per ogni componente occhio a sto cast

            componentList.add(component);

            // read next line before looping
            // if end of file reached, line would be null
            line = br.readLine();
        }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

    return componentList;
}


public  Gpu createComponentFromString(String[] metadata){

	

	String name1 = metadata[0];
	int price1 = Integer.parseInt(metadata[1].trim());
	int power1 = Integer.parseInt(metadata[2].trim());
	int memory1 = Integer.parseInt(metadata[3].trim());
	
	Gpu g1 = new Gpu(name1, price1, power1, memory1); 

return g1;
}


  @Override public String toString() { return "Gpu [name=" + this.getName() +
  ", price=" + this.getPrice() + ", power=" + this.getPower() +
  ", memory="+this.getMemory()+"]"; }
 
}
