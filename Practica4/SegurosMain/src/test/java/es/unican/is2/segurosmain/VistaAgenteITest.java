package es.unican.is2.segurosmain;




import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fest.swing.fixture.FrameFixture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.segurosbusiness.GestionSeguros;
import es.unican.is2.seguroscommon.IClientesDAO;
import es.unican.is2.seguroscommon.ISegurosDAO;
import es.unican.is2.segurosdao.ClientesDAO;
import es.unican.is2.segurosdao.SegurosDAO;
import es.unican.is2.segurosgui.VistaAgente;


public class VistaAgenteITest {
	
	
	private FrameFixture demo;
	
	@BeforeEach
	public void setUp() {
		
		IClientesDAO daoContribuyentes = new ClientesDAO();
		ISegurosDAO daoVehiculos = new SegurosDAO();
		GestionSeguros negocio = new GestionSeguros(daoContribuyentes, daoVehiculos);
		VistaAgente gui = new VistaAgente(negocio, negocio, negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		
		//comprobacion del boton
		demo.button("btnBuscar").requireText("Buscar");
		
		
		//buscar cliente existente
		demo.textBox("txtDNICliente").enterText("12345678S");
		
		demo.button("btnBuscar").click();
		
		demo.textBox("txtNombreCliente").requireText("Andres Ortega");
		
		demo.textBox("txtTotalCliente").requireText("675.0");
		
		
		assertTrue(demo.list("listSeguros").valueAt(0).equals("PLL9597 TODORIESGO"));
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//buscar un dni vacio
		demo.textBox("txtDNICliente").setText("");
		
		demo.button("btnBuscar").click();
		
		demo.textBox("txtNombreCliente").requireText("DNI No Válido");
		
		demo.textBox("txtTotalCliente").requireText("");
		
		//esta excepcion se lanza cuando la lista no tiene elementos ya que no existe ni el primer elemento
		assertThrows(IndexOutOfBoundsException.class , () -> demo.list("listSeguros").valueAt(0));
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//buscar cliente inexistente
		demo.textBox("txtDNICliente").setText("123");
				
		demo.button("btnBuscar").click();
				
		demo.textBox("txtNombreCliente").requireText("DNI No Válido");
				
		demo.textBox("txtTotalCliente").requireText("");
				
		//esta excepcion se lanza cuando la lista no tiene elementos ya que no existe ni el primer elemento
		assertThrows(IndexOutOfBoundsException.class , () -> demo.list("listSeguros").valueAt(0));
				
		//Sleep para visualizar como se realiza el test
		try {
					Thread.sleep(1000);
		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
