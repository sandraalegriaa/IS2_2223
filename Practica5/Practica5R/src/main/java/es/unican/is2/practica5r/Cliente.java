package es.unican.is2.practica5r;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public Direccion dir;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, String calle, String zip, String localidad, 
 			String telefono, String dni) {  //WMC + 1 CCog +0
		this.nombre = titular;
		this.dir = new Direccion(calle, zip, localidad);
		this.telefono = telefono;
		this.dni = dni;
	}
	
	
	
	public void anhadeCuenta(Cuenta c) { //WMC + 1 CCog +0
		Cuentas.add(c);
	}
	
	public double getSaldoTotal() { //WMC + 1
		double total = 0.0;
		for (Cuenta c: Cuentas) {  //WMC + 1 CCog +1
			total += c.getSaldo();
		}
		return total;
	}
	
	public String getNombre() { //WMC + 1 CCog +0
		return nombre;
	}

	public Direccion getDireccion() { //WMC + 1 Ccog +0 
		return dir;
	}
	
	public String getTelefono() { //WMC + 1 CCog +0
		return telefono;
	}

	public String getDni() { //WMC + 1
		return dni;
	}
	
	
	
}