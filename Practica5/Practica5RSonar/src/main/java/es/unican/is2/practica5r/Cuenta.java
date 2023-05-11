package es.unican.is2.practica5r;


public abstract class Cuenta {
	
	private String numCuenta;
	
	public Cuenta(String numCuenta) { //WMC +1 CCog +0
		this.numCuenta = numCuenta;
	}
	
	public String getNumCuenta() { //WMC +1 CCog +0
		return numCuenta;
	}
	
	public abstract double getSaldo(); //WMC +0 CCog +0
	
}
