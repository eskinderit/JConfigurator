package ConfiguratorEngine;

import javax.xml.bind.annotation.*;

@XmlTransient
public abstract class Component {

	@XmlElement(name="name")
	private String name;
	@XmlElement(name="price")
	private int price;
	@XmlElement(name="power")
	private int power;



public Component() {
	super();
}

public Component(String name, int price, int power) {
	super();
	this.name = name;
	this.price = price;
	this.power = power;
}



public int getPower() {
	return power;
}

public String getName() {
	return name;
}

public int getPrice() {
	return price;
}

//public abstract Component createComponentFromString(String[] metadata);


}



