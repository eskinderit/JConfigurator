package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import configuratorEngine.Component;
import configuratorEngine.FullConfig;

public abstract class ComponentAssembly<T extends Component> {
	protected boolean retry;
	protected boolean goback;
	protected ComponentAssembly<?> previousPassage;
	protected ComponentAssembly<?> nextPassage;

	public boolean isRetry() {
		return retry;
	}

	public boolean isGoback() {
		return goback;
	}

	/**
	 * this function should contain the behavior of the passage
	 * 
	 * @param f1    full configuration subject of comparison checks of the
	 *              corresponding assembly step or a usual read from a dao if there
	 *              are no checks to do
	 * @param index index of the component selected by input
	 * @throws JAXBException
	 */
	protected abstract void passageBehavior(FullConfig f1, int index) throws JAXBException;

	abstract public ArrayList<T> getCompatibleComponents(FullConfig f1) throws JAXBException;

	/**
	 * In this implementation InputBasedBehavior manages the input performing the
	 * requested operations if the input is a number corresponding to a compatible
	 * component index. This function uses the abstract method passageBehavior
	 * 
	 * @param assemblyStep
	 * @param f1           FullConfig to be managed by the user
	 * @param s
	 * @throws JAXBException
	 */
	public void InputBasedBehavior(FullConfig f1, String s) throws JAXBException {

		if (StringUtils.isNumeric(s)) {
			int selectedIndex = Integer.parseInt(s);
			int listSize;

			listSize = this.getCompatibleComponents(f1).size();

			if (selectedIndex < listSize && selectedIndex >= 0) {
				this.passageBehavior(f1, selectedIndex);
				retry = false;
			}

			else
				retry = true;

		}

		else if (s.contentEquals("back")) {
			this.goback = true;
		}

		else {
			System.out.println("The index of the selected component is not in the list");
			this.retry = true;
		}
	}

	public ComponentAssembly<?> getPreviousPassage1() {
		return previousPassage;
	}

	public void setPreviousPassage1(ComponentAssembly<?> previousPassage1) {
		this.previousPassage = previousPassage1;
	}

	public ComponentAssembly<?> getNextPassage1() {
		return nextPassage;
	}

	public void setNextPassage1(ComponentAssembly<?> nextPassage1) {
		this.nextPassage = nextPassage1;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}

	public void setGoback(boolean goback) {
		this.goback = goback;
	}
}