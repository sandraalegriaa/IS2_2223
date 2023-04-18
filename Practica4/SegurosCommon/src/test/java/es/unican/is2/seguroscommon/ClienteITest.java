package es.unican.is2.seguroscommon;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	
	
	private Seguro seguro1;
	private Seguro seguro2;
	private Seguro seguro3;
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	//private Cliente cliente4; no valido
	List<Seguro> segurosC = new ArrayList<Seguro>();
	List<Seguro> segurosCV = new ArrayList<Seguro>();
	
	@BeforeEach
	public void setUp() {
		seguro1 = new Seguro (Cobertura.TERCEROS, 90, LocalDate.of(2022, 10, 13), "a");
		seguro2 = new Seguro (Cobertura.TODORIESGO, 120, LocalDate.of(2021, 10, 13), "b");
		seguro3 = new Seguro (Cobertura.TERCEROSLUNAS, 50, LocalDate.of(2020, 10, 13), "c");
		
		segurosC.add(seguro1);
		segurosC.add(seguro2);
		segurosC.add(seguro3);
		
		cliente1 = new Cliente (segurosC, "Miguel", "12345678A", true);
		cliente2 = new Cliente (segurosC, "Nestor", "12345678B", false);
		cliente3 = new Cliente (segurosCV, "Isaac", "12345678C", true);
		//cliente4 = new Cliente (segurosCV, "Juan", "12345678D", null); 
		
	}
	
	
	
	@Test
	void testTotalSeguros() {
		
		//Casos validos
		
		assertTrue(cliente1.totalSeguros() == 1512);
		assertTrue(cliente2.totalSeguros() == 2016);
		assertTrue(cliente3.totalSeguros() == 0);
		
		
		
		
	}

}
