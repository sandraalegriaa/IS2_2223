package es.unican.is2.practica5r;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private LocalDate mFechaDeCaducidadTarjetaDebito;
	private LocalDate mFechaDeCaducidadTarjetaCredito;
	private double limiteDebito;
	private double saldo = 0;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) throws datoErroneoException { //WMC +1 CCog +0
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = date;
		this.mFechaDeCaducidadTarjetaCredito = date2;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double x) throws datoErroneoException { //WMC +1 Ccog +0
		String concepto = "Ingreso en efectivo";
		ingresar(concepto, x);
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1 Ccog +0
		String concepto = "Retirada de efectivo";
		retirar(concepto, x);
	}

	public void ingresar(String concepto, double x) throws datoErroneoException { //WMC +1 Ccog +0
		getionExcepcionesIngresar(x);
		LocalDateTime now = LocalDateTime.now();
		Movimiento m = new Movimiento(now, concepto, x);
		saldo += x;
		this.mMovimientos.add(m);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1 Ccog +0
		gestionExcepcionesRetirar(x);
		LocalDateTime now = LocalDateTime.now();
		Movimiento m = new Movimiento(now, concepto, -x);
		saldo -= x;
		this.mMovimientos.add(m);
	}
	
	private void getionExcepcionesIngresar(double x) { //WMC +1 
		if (x <= 0) //WMC +1 CCog +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
	}

	private void gestionExcepcionesRetirar(double x) { //WMC +1
		if (getSaldo() < x) //WMC +1 CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0) //WMC +1 CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
	}

	public double getSaldo() { //WMC +1 CCog +0
		return saldo;
	}

	public void addMovimiento(Movimiento m) { //WMC +1 CCog +0
		mMovimientos.add(m);
		saldo += m.getI();
	}

	public List<Movimiento> getMovimientos() { //WMC +1 CCog +0
		return mMovimientos;
	}

	public LocalDate getCaducidadDebito() { //WMC +1 CCog +0
		return this.mFechaDeCaducidadTarjetaDebito;
	}

	public LocalDate getCaducidadCredito() { //WMC +1 CCog +0
		return this.mFechaDeCaducidadTarjetaCredito;
	}

	public double getLimiteDebito() { //WMC +1 CCog +0
		return limiteDebito;
	}

}