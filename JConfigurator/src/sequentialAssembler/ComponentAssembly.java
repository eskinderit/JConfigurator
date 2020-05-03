package sequentialAssembler;

import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.StringUtils;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;

public abstract class ComponentAssembly implements ComponentCheck{
	protected boolean retry;
	protected boolean goback;

	ComponentAssembly(){
		this.retry = false;
		this.goback = false;
	}
	
	public boolean isRetry() {
		return retry;
	}
	
	public boolean isGoback() {
		return goback;
	}

	public abstract  ComponentAssembly getPreviousPassage();
	public abstract ComponentAssembly getNextPassage();

	protected abstract void passageBehavior(FullConfig f1, int index) throws JAXBException;

	abstract public ComponentDao<?,?> getComponentDao();

	public void InputBasedBehavior(ComponentAssembly assemblyStep, FullConfig f1, String s) throws JAXBException  {

		if(StringUtils.isNumeric(s)) {
			int selectedIndex = Integer.parseInt(s);
			int listSize;

			listSize = assemblyStep.getCompatibleComponents(f1).size();

			if (selectedIndex < listSize && selectedIndex>=0)
			{
				this.passageBehavior(f1, selectedIndex);
				retry=false;
			}

			else
				retry=true;

		}

		else if(s.contentEquals("back")){
			this.goback=true;
		}

		else {
			System.out.println("The index of the selected component is not in the list");
			this.retry=true;
		}
	}
}