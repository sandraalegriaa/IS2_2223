
package es.unican.is2.segurosbusiness;

import java.util.List;

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
	List<Cliente> clientes;
	List<Seguro> seguros;

	public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
		this.clientes = daoContribuyentes.clientes();
		this.seguros = daoVehiculos.seguros();
	}

	public Cliente cliente(String dni) {
		for (Cliente c: clientes) {
			if (c.getDni().equals(dni)) {
				return c;
			}
		}
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
