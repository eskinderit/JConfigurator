package sequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;

public abstract class ComponentAssembly<T extends Component> {
	protected boolean retry;
	protected boolean goback;
	ComponentAssembly<?> previousPassage1;
	ComponentAssembly<?> nextPassage1;

	public boolean isRetry() {
		return retry;
	}

	public boolean isGoback() {
		return goback;
	}

	/**
	 * @return the previous passage of the sequential assembly
	 */
	public abstract ComponentAssembly<?> getPreviousPassage();

	/**
	 * @return the next passage of the sequential assembly
	 */
	public abstract ComponentAssembly<?> getNextPassage();

	/**
	 * core of the behavior of the passage
	 * 
	 * @param f1    full configuration to manage in the step
	 * @param index index of the component selected by input
	 * @throws JAXBException
	 */
	protected abstract void passageBehavior(FullConfig f1, int index) throws JAXBException;

	/**
	 * Abstract factory
	 * 
	 * @return
	 */
	abstract public ComponentDao<T, ?> getComponentDao();

	abstract public ArrayList<T> getCompatibleComponents(FullConfig f1) throws JAXBException;

	public void InputBasedBehavior(ComponentAssembly<?> assemblyStep, FullConfig f1, String s) throws JAXBException {

		if (StringUtils.isNumeric(s)) {
			int selectedIndex = Integer.parseInt(s);
			int listSize;

			listSize = assemblyStep.getCompatibleComponents(f1).size();

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
		return previousPassage1;
	}

	public void setPreviousPassage1(ComponentAssembly<?> previousPassage1) {
		this.previousPassage1 = previousPassage1;
	}

	public ComponentAssembly<?> getNextPassage1() {
		return nextPassage1;
	}

	public void setNextPassage1(ComponentAssembly<?> nextPassage1) {
		this.nextPassage1 = nextPassage1;
	}
}