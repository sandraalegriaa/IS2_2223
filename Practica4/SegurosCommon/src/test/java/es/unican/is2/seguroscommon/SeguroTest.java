package es.unican.is2.seguroscommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class SeguroTest {
	
	private Seguro seguro1;
	private Seguro seguro2;
	private Seguro seguro3;
	//private Seguro seguro4;
	private Seguro seguro5;
	//private Seguro seguro6;
	private Seguro seguro7;
	private Seguro seguro8;
	
	@BeforeEach
	public void setUp() throws Exception {
		seguro1 = new Seguro (Cobertura.TERCEROS, 90, LocalDate.of(2022, 10, 13), "a");
		seguro2 = new Seguro (Cobertura.TODORIESGO, 120, LocalDate.of(2022, 10, 13), "b");
		seguro3 = new Seguro (Cobertura.TERCEROSLUNAS, 50, LocalDate.of(2020, 10, 13), "c");
		//seguro4 = new Seguro (Cobertura.NOVEL, 90, LocalDate.of(2022, 10, 13), "d");
		seguro5 = new Seguro (Cobertura.TERCEROS, -10, LocalDate.of(2022, 10, 13), "e");
		//seguro6 = new Seguro (Cobertura.TERCEROS, null, LocalDate.of(2022, 10, 13), "f");
		seguro7 = new Seguro (Cobertura.TODORIESGO, 90, LocalDate.of(2023, 10, 13), "g");
		seguro8 = new Seguro (Cobertura.TERCEROS, 90, null, "h");
	}

	@Test
	public void testGetMatricula() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCobertura() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPotencia() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public void testPrecio() throws PotenciaNegaivaEx{
		
		//casos de prueba valido
		assertTrue(seguro1.precio() == 336);
		
		assertTrue(seguro2.precio() == 1080);
		
		assertTrue(seguro3.precio() == 600);
		
		//casos de prueba no valido
		
		assertThrows(PotenciaNegativaEx, seguro5.precio());
		
	}

}
