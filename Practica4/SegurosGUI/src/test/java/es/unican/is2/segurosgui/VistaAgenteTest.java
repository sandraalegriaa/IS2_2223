package es.unican.is2.segurosgui;



import static org.junit.jupiter.api.Assertions.fail;

import org.fest.swing.fixture.FrameFixture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VistaAgenteTest {
	
	
	private FrameFixture demo;
	
	@BeforeEach
	public void setUp() {
		VistaAgente gui = new VistaAgente(null, null, null);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
