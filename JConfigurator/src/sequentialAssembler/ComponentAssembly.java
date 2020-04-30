package sequentialAssembler;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import ConfiguratorEngine.Component;
import ConfiguratorEngine.FullConfig;
import dataSource.ComponentDao;

abstract class ComponentAssembly {
	boolean retry;
	boolean goback;
	
	ComponentAssembly previousPassage;
	ComponentAssembly nextPassage;
	
	
	ComponentAssembly(){
		this.retry = false;
		this.goback = false;
	}

protected abstract void passageBehavior(FullConfig f1, int index);
	
public <T1 extends Component, T2 extends ComponentDao<T1,T2>> void execute(T2 componentDao, FullConfig f1, String s)  {
		
		if(StringUtils.isNumeric(s)) {
			int selectedIndex = Integer.parseInt(s);
			int listSize;
			try {
				
				listSize = componentDao.readComponents().size();
				
				if (selectedIndex < listSize && selectedIndex>=0)
					this.passageBehavior(f1, selectedIndex);
				
				else
					retry=true;
			}
			
			catch (JAXBException e) {
				System.out.println("The program didn't find the xml source file of the component");
				e.printStackTrace();
			}	
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