package dataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.annotation.*;

import javax.xml.bind.*;

import ConfiguratorEngine.Ram;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RamDao {
	
	@XmlElement(name="ram")
	ArrayList<Ram> ram;
	
	public RamDao() {
		this.ram=new ArrayList<Ram>();
	}


	private ArrayList<Ram> getRamList() {
		return this.ram;
	}

	private void setRamList(ArrayList<Ram> ram) {
		this.ram = ram;
	}
	
	private void addRamList(ArrayList<Ram>r) {
		this.ram.addAll(r);
	}
	
	static {
		Ram ram1=new Ram("Kingston HyperX Fury DDR3 (2x4)", 67, 10, "DDR3", 8);
		Ram ram2=new Ram("Kingston HyperX Fury DDR4 (2x4)", 67, 10, "DDR3", 8);
		Ram ram3=new Ram("Corsair Dominator Platinum DDR4 (4x8)", 318, 10, "DDR4", 32);
		Ram ram4=new Ram("Corsair Vengeance Pro DDR3 (2x8)", 125, 10, "DDR3", 16);
		Ram ram5=new Ram("Ballistix Sport LT DDR4 (2x8)", 133, 10, "DDR4", 16);
		Ram ram6=new Ram("Corsair DDR4 4GB", 35, 10,"DDR4", 4);
		Ram ram7=new Ram("Kingston HyperX Fury DDR4 (2x8)", 142, 10, "DDR4", 16);
		
		ArrayList<Ram> r=new ArrayList<Ram>();
		
		r.add(ram1);
		r.add(ram2);
		r.add(ram3);
		r.add(ram4);
		r.add(ram5);
		r.add(ram6);
		r.add(ram7);
		
	}
	
	public ArrayList<Ram> setRamFile() throws JAXBException {

		RamDao ramDao=new RamDao();
		JAXBContext context=JAXBContext.newInstance(RamDao.class);
		Marshaller mrs=context.createMarshaller();
		mrs.marshal(ramDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.xml"));

		return ramDao.getRamList();
	}
	
	
	public ArrayList<Ram> readRams() throws JAXBException{

		JAXBContext context=JAXBContext.newInstance(RamDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		RamDao ramDao = (RamDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.Xml"));

		return ramDao.getRamList();
	}
	
	
	public ArrayList<Ram> setDefaultRamFile() throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(RamDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		RamDao ramDao = (RamDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\RamDefault.Xml"));
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		File fout=new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.xml");
		mrs.marshal(ramDao, fout);
		return ramDao.getRamList();
		
	}
	
	
	
	public ArrayList<Ram> addRams(ArrayList<Ram>ramToAdd) throws JAXBException{
		
		JAXBContext context=JAXBContext.newInstance(RamDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		RamDao ramDao = (RamDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.Xml"));
		
		ramDao.addRamList(ramToAdd);
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(ramDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.Xml"));
		
		return ramDao.getRamList();
	}
	
	public ArrayList<Ram> removeRams(int ramsToRemove[]) throws JAXBException{

		JAXBContext context=JAXBContext.newInstance(RamDao.class);
		Unmarshaller ums=context.createUnmarshaller();
		RamDao ramDao =(RamDao)ums.unmarshal(new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.xml"));

		Arrays.sort(ramsToRemove);

		for(int i=0; i<ramsToRemove.length; i++) {
			for (int j=0; j<ramDao.getRamList().size(); j++) {
				if(ramsToRemove[i]==j) {
					ramDao.getRamList().remove(j);
					for(int k=i; k<ramsToRemove.length; k++) {
						ramsToRemove[k]=ramsToRemove[k]-1;
					}
				}
			}
		}
		
		Marshaller mrs =context.createMarshaller();
		mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mrs.marshal(ramDao, new File("C:\\Users\\ralu1\\git\\JConfigurator\\JConfigurator\\src\\dataSource\\Ram.Xml"));
		
		return ramDao.getRamList();

	}
}
