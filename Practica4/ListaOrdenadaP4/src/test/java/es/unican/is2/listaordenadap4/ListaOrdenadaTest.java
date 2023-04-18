package es.unican.is2.listaordenadap4;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class ListaOrdenadaTest {
	private IListaOrdenada<Integer> lista;
	
	@BeforeEach
	public void setUp() {
		lista = new ListaOrdenada<>();
		
		
	}
	
	@Test
	public void Test() {
		
		//caso no valido get y remove con lista vacia
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(0));
		
		//caso valido size con lista vacia
		assertTrue(lista.size() == 0);
		
		//caso valido add y get con lista vacia
		lista.add(1);
		assertTrue(lista.get(0) == 1);
		
		//caso valido add con lista con elementos
		lista.add(2);
		lista.add(4);
		lista.add(3);
		assertTrue(lista.get(0) == 1 && lista.get(1) == 2 && lista.get(2) == 3 && lista.get(3) == 4);
		
		//caso no valido get y remove con indice < 0
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
		
		//caso valido remove con lista con elementos
		assertTrue(lista.remove(0) == 1);
		assertTrue(lista.get(0) == 2 && lista.get(1) == 3 && lista.get(2) == 4);
		
		//caso valido size con lista con elementos
		assertTrue(lista.size() == 3);
		
		//casos validos clean y size
		
		lista.clear();
		assertTrue(lista.size() == 0);
		lista.clear();
		assertTrue(lista.size() == 0);
		
	}

}