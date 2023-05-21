package es.unican.is2.practica5r;

import java.time.LocalDate;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, CuentaAhorro c) { //WMC +1 CCog +0
		super(numero, titular, c);
	}
	
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1	
		String concepto = "Retirada en cajero autom�tico";
		retirarDinero(concepto, x);
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		String concepto = "Compra en : " + datos;
		retirarDinero(concepto, x);
	}
	
	public void retirarDinero(String concepto, double x) { //Wmc+1
		if (saldoDiarioDisponible<x) { //WMC +1 CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar(concepto, x);
		saldoDiarioDisponible-=x;
	}
	
	public LocalDate getCaducidadDebito() { //WMC +1 CCog +0
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() { //WMC +1 CCog +0
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() { //WMC +1 CCog +0
		return mCuentaAsociada;
	}

}