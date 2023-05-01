package es.unican.is2.practica5r;

import java.time.LocalDateTime;

public class Movimiento {
	
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;
	
	public Movimiento() {} //WMC +1 CCog +0
	
	public Movimiento (LocalDateTime f, String c, double i) { //WMC +1 CCog +0
		this.mConcepto = c;
		this.mFecha = f;
		this.mImporte = i;
	}

	public double getI() { //WMC +1 CCog +0
		return mImporte;
	}

	public void setI(double newMImporte) { //WMC +1 CCog +0
		mImporte = newMImporte;
	}
	
	public String getC() { //WMC +1 CCog +0
		return mConcepto;
	}

	public void setC(String newMConcepto) { //WMC +1 CCog +0
		mConcepto = newMConcepto;
	}

	public LocalDateTime getF() { //WMC +1 CCog +0
		return mFecha;
	}

	public void setF(LocalDateTime newMFecha) { //WMC +1 CCog +0
		mFecha = newMFecha;
	}
	
}