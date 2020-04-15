package ConfiguratorEngine;
import javax.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Gpu extends Component {

private int memory;

public Gpu(String name, int price, int power, int memory) {
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



  @Override public String toString() { return "Gpu [name=" + this.getName() +
  ", price=" + this.getPrice() + ", power=" + this.getPower() +
  ", memory="+this.getMemory()+"]"; }
 
}
