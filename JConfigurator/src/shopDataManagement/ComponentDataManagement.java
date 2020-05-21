package shopDataManagement;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Component;

import dataSource.ComponentDao;


public abstract class ComponentDataManagement<T extends Component> {
	
	private String name;
	private int price;
	private int power;
	
	
	abstract public ComponentDao<T, ?> getComponentDao ();

	/**
	 * Deletes a component with index index, from his respective list, 
	 * @param index
	 * @return ArrayList<T>
	 * @throws JAXBException
	 */

	abstract public  ArrayList<T> deleteComp (int index) throws JAXBException;
	
	/**
	 * Adds a component to his respective list, with parameters entered by the user.
	 * @param parameter
	 * @return ArrayList<T>
	 * @throws JAXBException
	 */
	
	abstract public  ArrayList<T> addComp (Scanner parameter) throws JAXBException;
	
	/**
	 * Restores the respective default list of a component
	 * @return ArrayList<T>
	 * @throws JAXBException
	 */
	
	abstract public  ArrayList<T> resetComp() throws JAXBException;
	
	
	
	
	
	/**
	 * Setters of name, price, power (parameters in common with all components).
	 * Parameters are entered by the user.
	 * @param parameter
	 */
	
	
	protected void setName (Scanner parameter) {

		System.out.println("Nome: ");
		this.name = parameter.nextLine();
		
		
	}
	
	protected void setPrice (Scanner parameter) {
		String input;
		do {
			System.out.println("Prezzo: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		this.price = Integer.parseInt(input);
		
	}
	
	protected void setPower(Scanner parameter) {
		String input;
		do {
			System.out.println("Potenza: ");
			input = parameter.nextLine();
		}while(!StringUtils.isNumeric(input));
		this.power = Integer.parseInt(input);
	}
	
	
	/**
	 * getters of name, price, power parameters.
	 */
	
	
	public String getName() {
		return this.name;
	}


	public int getPrice() {
		return this.price;
	}


	public int getPower() {
		return this.power;
	}
}
