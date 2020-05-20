package sequentialAssembler;

import configuratorEngine.Case;
import configuratorEngine.Cpu;
import configuratorEngine.FullConfig;
import configuratorEngine.Motherboard;
import configuratorEngine.Psu;
import configuratorEngine.Ram;

public class CompatibilityCheckAlgs {

	/**
	 * Checks if a motherboard and a case are compatible by comparing the sizes on
	 * both
	 * 
	 * @param m1 Motherboard to be checked
	 * @param c1 Case to be checked
	 * @return the result of the check (true if compatible, false if not)
	 */
	static public boolean checkMotherboardCase(Motherboard m1, Case c1) {
		if (c1.getSize() >= m1.getSize())
			return true;
		else
			return false;
	}

	/**
	 * Checks if a motherboard and a ram are compatible by comparing the type of ram
	 * socket on both
	 * 
	 * @param m1 Motherboard to be checked
	 * @param r1 Ram to be checked
	 * @return the result of the check (true if compatible, false if not)
	 */
	static public boolean checkMotherboardRam(Motherboard m1, Ram r1) {
		if (r1.getRamType().contentEquals(m1.getRamType()))
			return true;
		else
			return false;
	}

	/**
	 * Checks if a motherboard and a cpu are compatible by comparing the cpu socket
	 * on both
	 * 
	 * @param c1 Case to be checked
	 * @param m1 Motherboard to be checked
	 * @return the result of the check (true if compatible, false if not)
	 */
	static public boolean checkMotherboardCpu(Cpu c1, Motherboard m1) {
		if (m1.getSocket().contentEquals(c1.getSocket()))
			return true;
		else
			return false;
	}

	/**
	 * Checks if a psu is enough powerful to power the whole pc with an overhead
	 * fixed by configuration
	 * 
	 * @param f1  the full configuration of the pc
	 * @param psu Psu to check
	 * @return the result of the check (true if compatible, false if not)
	 */
	static public boolean checkTotalWattagePsu(FullConfig f1, Psu psu) {
		if (psu.getPower() - f1.getSubtotalPower() > f1.getPsuOverhead())
			return true;
		else
			return false;
	}

}
