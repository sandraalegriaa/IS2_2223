package es.unican.is2.practica5r;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CuentaAhorroTest {
	private CuentaAhorro sut;
	private static Movimiento m1, m2, m3;
	
	@BeforeAll
	public static void inicializaAuxiliares() {
		m1 = new Movimiento();
		m1.setI(100);
		m2 = new Movimiento();
		m2.setI(200);
		m3 = new Movimiento();
		m3.setI(1500);
	}

	@BeforeEach
	public void inicializa() {
		sut = new CuentaAhorro("794311", LocalDate.now().plusYears(3), LocalDate.now().plusYears(4));
	}

	@Test
	public void testConstructor() {
		assertEquals(sut.getCaducidadDebito(), LocalDate.now().plusYears(3));
		assertEquals(sut.getCaducidadCredito(),LocalDate.now().plusYears(4));
		assertEquals(1000, sut.getLimiteDebito());
		assertEquals(0, sut.getMovimientos().size());
		assertEquals("794311", sut.getNumCuenta());
	}
	
	@Test
	public void testGetSaldoYAddMovimiento() {
		assertEquals(0, sut.getSaldo());	

		sut.addMovimiento(m1);
		assertEquals(100, sut.getSaldo());
		assertEquals(1, sut.getMovimientos().size());
		
		sut.addMovimiento(m2);
		sut.addMovimiento(m3);
		assertEquals(1800, sut.getSaldo());
		assertEquals(3, sut.getMovimientos().size());
	}
	
	@Test
	public void testRetirarSinConcepto() {
		
		try {
			sut.retirar(-10);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (datoErroneoException e) {
		} catch (saldoInsuficienteException e) {
			fail("Deber�a lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try {
			sut.retirar(50);
			assertEquals(50, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Retirada de efectivo", sut.getMovimientos().get(1).getC());
		} catch (datoErroneoException e) {
			fail("No deber�a lanzar DatoErroneoException");
		} catch (saldoInsuficienteException e) {
			fail("No deber�a lanzar SaldoInsuficienteException");
		}
		
		
		try {
			sut.retirar(100);
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (datoErroneoException e) {
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (saldoInsuficienteException e) { }
	
	}
	
	@Test
	public void testIngresarSinConcepto () {
	
		try {
			sut.ingresar(-1);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (datoErroneoException e) {
		}

		try {
			sut.ingresar(0.01);
			assertEquals(0.01, sut.getSaldo());
			assertEquals(1, sut.getMovimientos().size());
			assertEquals("Ingreso en efectivo", sut.getMovimientos().get(0).getC());
			
			sut.ingresar(100);
			assertEquals(100.01, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			
		} catch (datoErroneoException e) {
			fail("No deber�a lanzar la excepci�n");
		}
		
	}
	
	
	@Test
	public void testIngresarConConcepto () {
	
		// Test ingresar negativo
		try {
			sut.ingresar("Ingreso", -1);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (datoErroneoException e) {
		}

		// Test ingresar el limite
		try {
			sut.ingresar("Ingreso1", 0.01);
			assertEquals(0.01, sut.getSaldo());
			assertEquals(1, sut.getMovimientos().size());
			assertEquals("Ingreso1", sut.getMovimientos().get(0).getC());
			
			sut.ingresar("Ingreso2", 100);
			assertEquals(100.01, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Ingreso2", sut.getMovimientos().get(1).getC());
			
		} catch (datoErroneoException e) {
			fail("No deber�a lanzar la excepci�n");
		}
		
	}
	
	@Test
	public void testRetirarConConcepto() {
		
		try {
			sut.retirar("Retirada", -10);
			fail("Deber�a lanzar DatoErroneoException");
		} catch (datoErroneoException e) {
		} catch (saldoInsuficienteException e) {
			fail("Deber�a lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try {
			sut.retirar("Retirada1", 50);
			assertEquals(50, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Retirada1", sut.getMovimientos().get(1).getC());
		} catch (datoErroneoException e) {
			fail("No deber�a lanzar DatoErroneoException");
		} catch (saldoInsuficienteException e) {
			fail("No deber�a lanzar SaldoInsuficienteException");
		}
		
		
		try {
			sut.retirar("Retirada2", 100);
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (datoErroneoException e) {
			fail("Deber�a lanzar SaldoInsuficienteException");
		} catch (saldoInsuficienteException e) {
			
		}
	
	}

	
}
