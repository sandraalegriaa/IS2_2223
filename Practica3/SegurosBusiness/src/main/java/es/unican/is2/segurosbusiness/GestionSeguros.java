
package es.unican.is2.segurosbusiness;

import es.unican.is2.seguroscommon.Cliente;
import es.unican.is2.seguroscommon.IClientesDAO;
import es.unican.is2.seguroscommon.IGestionClientes;
import es.unican.is2.seguroscommon.IGestionSeguros;
import es.unican.is2.seguroscommon.IInfoSeguros;
import es.unican.is2.seguroscommon.ISegurosDAO;
import es.unican.is2.seguroscommon.OperacionNoValida;
import es.unican.is2.seguroscommon.Seguro;

public class GestionSeguros implements IGestionClientes, IGestionSeguros,
IInfoSeguros{

	public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
		// TODO Auto-generated constructor stub
	}

	public Cliente cliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seguro seguro(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}

	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente nuevoCliente(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente bajaCliente(String dni) throws OperacionNoValida {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
