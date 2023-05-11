package es.unican.is2.practica5r;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {
	
	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;
	
	
	public Credito(String numero, String titular, CuentaAhorro c, double credito) { //WMC +1 CCog +0
		super(numero, titular, c);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisi�n del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {//WMC +1
		if (x<0) //WMC +1 CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		x += x * 0.05; // A�adimos una comisi�n de un 5%
	
		LocalDateTime now = LocalDateTime.now();
		Movimiento m = new Movimiento(now, "Retirada en cajero autom�tico", -x);
		
		
		if (getGastosAcumulados()+x > mCredito) //WMC +1 CCog +1
			throw new saldoInsuficienteException("Cr�dito insuficiente");
		
		mMovimientosMensuales.add(m);
		
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		if (x<0) //WMC +1 CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		if (getGastosAcumulados() + x > mCredito) //WMC +1 CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		
		LocalDateTime now = LocalDateTime.now();
		Movimiento m = new Movimiento(now, "Compra a cr�dito en: " + datos, -x);
		
		mMovimientosMensuales.add(m);
	}
	
    public double getGastosAcumulados() { //WMC +1
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) { //WMC +1 CCog +1
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getI();
		}
		return -r;
	}
	
	
	public LocalDate getCaducidadCredito() { //WMC +1 CCog +0
		return this.mCuentaAsociada.getCaducidadCredito();
	}

	/**
	 * M�todo que se invoca autom�ticamente el d�a 1 de cada mes
	 */
	public void liquidar() { //WMC +1
		
		LocalDateTime now = LocalDateTime.now();
		
		double r = -getGastosAcumulados();
		
		Movimiento liq = new Movimiento(now, "Liquidaci�n de operaciones tarjeta cr�dito", r);
	
		if (r != 0) //WMC +1 CCog +1
			mCuentaAsociada.addMovimiento(liq);
		
		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
	}

	public List<Movimiento> getMovimientosUltimoMes() { //WMC +1 CCog +0
		return mMovimientosMensuales;
	}
	
	public Cuenta getCuentaAsociada() { //WMC +1 CCog +0
		return mCuentaAsociada;
	}
	
	public List<Movimiento> getMovimientos() { //WMC +1 CCog +0
		return mhistoricoMovimientos;
	}

}