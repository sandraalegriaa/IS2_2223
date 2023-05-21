 package es.unican.is2.practica5r;

import java.util.LinkedList;
import java.util.List;

public class CuentaValores extends Cuenta {

	private List<Valor> valores;
	
	public CuentaValores(String numCuenta) { //WMC +1 CCog +0
		super(numCuenta);
		valores = new LinkedList<Valor>();
	}
	
	public List<Valor> getValores() { //WMC +1 CCog +0
		return valores;
	}
	
	public boolean anhadeValor(Valor valor) { //WMC +1
		for (Valor v:valores) { //WMC +1 CCog +1
			if (v.getEntidad().equals(valor.getEntidad())) //WMC +1 CCog +2
				return false;
		}
		valores.add(valor);
		return true;
	}
	
	public double getSaldo() { //WMC +1
		double saldo = 0;
		for (Valor v: valores) { //WMC +1 CCog +1
			saldo += v.getCotizacion()*v.getNumValores();
		}
		return saldo;
		
	}
	
}
