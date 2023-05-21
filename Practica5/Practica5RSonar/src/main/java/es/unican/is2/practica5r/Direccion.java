package es.unican.is2.practica5r;

public class Direccion {
	public String calle;
	public String zip;
	public String localidad;

	public Direccion(String calle, String zip, String localidad) { //WMC +1 CCog + 0 
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	public String getCalle() { //WMC + 1 CCog +0
		return this.calle;
	}

	public String getZip() { //WMC + 1 CCog +0
		return this.zip;
	}

	public String getLocalidad() { //WMC + 1 CCog +0
		return this.localidad;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) { //WMC + 1 CCog +0
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
}