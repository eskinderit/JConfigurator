package ConfiguratorEngine;

import javax.xml.bind.annotation.*;

@XmlTransient
public abstract class Component {

	@XmlElement(name="name")
	protected String name;
	@XmlElement(name="price")
	protected int price;
	@XmlElement(name="power")
	protected int power;


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



}



