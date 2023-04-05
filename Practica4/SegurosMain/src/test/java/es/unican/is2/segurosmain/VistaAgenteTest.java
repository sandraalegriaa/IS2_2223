package es.unican.is2.segurosmain;




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


public class VistaAgenteTest {
	
	
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
		demo.button("btnBuscar").requireText("Buscar");
		
		
		//buscar cliente existente
		demo.textBox("txtDNICliente").enterText("12345678S");
		
		demo.button("btnBuscar").click();
		
		demo.textBox("txtNombreCliente").requireText("Andres Ortega");
		
		demo.textBox("txtTotalCliente").requireText("675.0");
		
		demo.list("listSeguros").valueAt(0);
		assertTrue(demo.list("listSeguros").valueAt(0) == "PLL9597 TODORIESGO");
		
		//buscar cliente inexistente
		/*demo.textBox("txtDniCliente").enterText("321");
		
		demo.textBox("txtNombreCliente").requireText("Cliente no encontrado");
		
		demo.textBox("txtTotalCliente").requireText("");
		
		demo.list("listSeguros").valueAt(0);
		assertTrue(demo.list("listSeguros").valueAt(0) == "");*/
		
	}

}
