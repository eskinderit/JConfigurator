package ConfiguratorEngine;


public abstract class Component {
private String name;
private int price;
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



