package es.unican.is2.seguroscommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.seguroscommon.Seguro.FechaContratacionFuturaEx;
import es.unican.is2.seguroscommon.Seguro.FechaNulaEx;
import es.unican.is2.seguroscommon.Seguro.PotenciaNegativaEx;

public class SeguroTest {
	
	private Seguro seguro1;
	private Seguro seguro2;
	private Seguro seguro3;
	//private Seguro seguro4; //no se puede implementar
	private Seguro seguro5;
	//private Seguro seguro6; //no se puede implementar
	private Seguro seguro7;
	private Seguro seguro8;
	
	@BeforeEach
	public void setUp() {
		seguro1 = new Seguro (Cobertura.TERCEROS, 90, LocalDate.of(2022, 10, 13), "a");
		seguro2 = new Seguro (Cobertura.TODORIESGO, 120, LocalDate.of(2021, 10, 13), "b");
		seguro3 = new Seguro (Cobertura.TERCEROSLUNAS, 50, LocalDate.of(2020, 10, 13), "c");
		//seguro4 = new Seguro (Cobertura.NOVEL, 90, LocalDate.of(2022, 10, 13), "d");
		seguro5 = new Seguro (Cobertura.TERCEROS, -10, LocalDate.of(2022, 10, 13), "e");
		//seguro6 = new Seguro (Cobertura.TERCEROS, null, LocalDate.of(2022, 10, 13), "f");
		seguro7 = new Seguro (Cobertura.TODORIESGO, 90, LocalDate.of(2023, 10, 13), "g");
		seguro8 = new Seguro (Cobertura.TERCEROS, 90, null, "h");
	}
	
	
	@Test
	public void testPrecio(){
		
		//casos de prueba valido
		assertTrue(seguro1.precio() == 336);
		
		assertTrue(seguro2.precio() == 1080);
		
		assertTrue(seguro3.precio() == 600);
		
		//casos de prueba no valido
		
		assertThrows(PotenciaNegativaEx.class, () -> seguro5.precio());
		
		
		assertThrows(FechaContratacionFuturaEx.class, () -> seguro7.precio());
		
		
		assertThrows(FechaNulaEx.class,() -> seguro8.precio());
		
	}

}
