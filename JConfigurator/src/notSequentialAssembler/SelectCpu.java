package notSequentialAssembler;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import ConfiguratorEngine.Cpu;
import ConfiguratorEngine.FullConfigBuilder;
import dataSource.CpuDao;
import sequentialAssembler.CompatibilityCheckAlgs;

public class SelectCpu extends SelectComponent {
	private CpuDao cpu;
	
	public SelectCpu() {
		cpu=new CpuDao();
	}
	
	
	@Override
	public void readComponent() throws JAXBException{
		System.out.println("Select a cpu:\n");
		for(Cpu c:cpu.readComponents()) {
			System.out.println(c);
		}
	}

	@Override
	public void selectComp(int n, FullConfigBuilder f) throws JAXBException {
		f.cpu(cpu.readComponents().get(n));
	}


	@Override
	public ArrayList<Cpu> getCompatibleComponents(FullConfigBuilder f) throws JAXBException {
		ArrayList<Cpu> cpuList = new ArrayList<Cpu>();
		if(f.getMyMotherboard() != null) {
			cpuList=CompatibilityCheckAlgs.getCompatibleCpusByMotherboard(f);
		}
		else
			cpuList=cpu.readComponents();
		
		System.out.println("Select a cpu from list:\n");
		for(Cpu c:cpuList){
			System.out.println(c);
		}
		return cpuList;	
	}

	
	
}
