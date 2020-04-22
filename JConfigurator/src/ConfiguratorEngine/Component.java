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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + power;
	result = prime * result + price;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Component other = (Component) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (power != other.power)
		return false;
	if (price != other.price)
		return false;
	return true;
}



}



