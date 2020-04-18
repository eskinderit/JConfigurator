package dataSource;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ConfiguratorEngine.Cpu;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CpuDao {
	
	@XmlElement(name="cpu")
	private ArrayList <Cpu> cpu;
	
	
	public CpuDao() {
		this.cpu=new ArrayList<Cpu>();
	}

	private ArrayList<Cpu> getCpuList() {
		return this.cpu;
	}

	private void setCpuList(ArrayList<Cpu> cpu) {
		this.cpu = cpu;
	}
	
	private void addCpuList(ArrayList<Cpu> c) {
		cpu.addAll(c);
	}
	public Cpu getCpu(int i) {
		return cpu.get(i);
	}
	

	static{
		
		Cpu cpu1 = new Cpu("Intel Pentium G4520 (lga 1151)", 95, 10, "LGA1151", true);
		Cpu cpu2 = new Cpu("Intel Core i5 7400 (lga 1151)", 178, 10, "LGA1151", false);
		Cpu cpu3 = new Cpu("AMD Ryzen 5 1400 (AM4)", 176, 10, "AM4", true);
		Cpu cpu4 = new Cpu("Intel i5 7600K (lga 1151)", 222, 10, "LGA1151", true);
		Cpu cpu5 = new Cpu("Intel i5 7600 (lga 1151)", 211, 10, "LGA1151", false);
		Cpu cpu6 = new Cpu("Intel i7 7700 (lga 1151)", 313, 10, "LGA1151", false);
		Cpu cpu7 = new Cpu("AMD Ryzen 7 1800x (AM4)", 425, 10, "AM4", true);
		Cpu cpu8 = new Cpu("Intel i7 6950x (lga 2011)", 1571, 10, "LGA2011", true);
		
		ArrayList<Cpu> c = new ArrayList<Cpu>();
		
		c.add(cpu1);
		c.add(cpu2);
		c.add(cpu3);
		c.add(cpu4);
		c.add(cpu5);
		c.add(cpu6);
		c.add(cpu7);
		c.add(cpu8);
	}
	
	
	public ArrayList<Cpu> setCpuFile() throws JAXBException {
		
		CpuDao cpuDao=new CpuDao();
		JAXBContext context=JAXBContext.newInstance(CpuDao.class);
		Marshaller mrs=context.createMarshaller();
		mrs.marshal(cpuDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		
		return cpuDao.getCpuList();
	}
	
	public ArrayList<Cpu> readCpus() throws JAXBException{
		
		JAXBContext context=JAXBContext.newInstance(CpuDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		CpuDao cpuDao =(CpuDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));

		return cpuDao.getCpuList();
	}
	
	public ArrayList<Cpu> addCpus(ArrayList<Cpu> cpusToAdd) throws JAXBException {
		JAXBContext context=JAXBContext.newInstance(CpuDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		CpuDao cpuDao =(CpuDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		
		cpuDao.addCpuList(cpusToAdd);
		
		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		mrs.marshal(cpuDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		return cpuDao.getCpuList();
	}
	
	public ArrayList<Cpu> removeCpus(int cpusToRemove[]) throws JAXBException{
		
		JAXBContext context=JAXBContext.newInstance(CpuDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		CpuDao cpuDao =(CpuDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		
		Arrays.sort(cpusToRemove);
		
		for(int i=0; i<cpusToRemove.length; i++) {
			for (int j=0; j<cpuDao.getCpuList().size(); j++) {
				if(cpusToRemove[i]==j) {
					cpuDao.getCpuList().remove(j);
					for(int k=i; k<cpusToRemove.length; k++) {
						cpusToRemove[k]=cpusToRemove[k]-1;
					}
				}
			}
		}
		
		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		mrs.marshal(cpuDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		return cpuDao.getCpuList();
		
	}
	
public ArrayList<Cpu> setDefaultCpuFile() throws JAXBException {
		
		JAXBContext context=JAXBContext.newInstance(CpuDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		CpuDao cpuDao =(CpuDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\CpuDefault.xml"));
		
		Marshaller mrs = context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(cpuDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Cpu.xml"));
		
		return cpuDao.getCpuList();
	}
	
}
