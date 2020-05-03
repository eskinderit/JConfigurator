package sequentialAssembler;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;

public abstract class ComponentAssembly {
	protected boolean retry;
	protected boolean goback;

	
	public boolean isRetry() {
		return retry;
	}

	public boolean isGoback() {
		return goback;
	}

	abstract public ComponentAssembly getPreviousPassage();
	abstract public ComponentAssembly getNextPassage();
	

	ComponentAssembly(){
		this.retry = false;
		this.goback = false;
	}

protected abstract void passageBehavior(FullConfig f1, int index) throws JAXBException;

abstract public ComponentDao<?,?> getComponentDao();

public void InputBasedBehavior(ComponentDao<?, ?> componentDao, FullConfig f1, String s) throws JAXBException  {
		
		if(StringUtils.isNumeric(s)) {
			int selectedIndex = Integer.parseInt(s);
			int listSize;

				listSize = componentDao.readComponents().size();
				
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