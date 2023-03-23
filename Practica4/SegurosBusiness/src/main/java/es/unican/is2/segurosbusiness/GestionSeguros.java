
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
	
	IClientesDAO daoC;
	ISegurosDAO daoV;
	List<Cliente> clientes;
	List<Seguro> seguros;

	public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
		this.clientes = daoContribuyentes.clientes();
		this.seguros = daoVehiculos.seguros();
		this.daoC = daoContribuyentes;
		this.daoV= daoVehiculos;
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
		
		for (Seguro s: seguros) {
			if (s.getMatricula().equals(matricula)) {
				return s;
			}
		}
		return null;
	}

	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida {
		Cliente c = cliente(dni);
		if (c == null) {
			return null;
		}
		List<Seguro> segurosC = c.getSeguros();
		
		for (Seguro seg: segurosC) {
			if (seg.equals(s)) {
				throw new OperacionNoValida("El seguro ya existe");
			}
		}
		segurosC.add(s);
		c.setSeguros(segurosC);
		daoC.actualizaCliente(c);
		
		return s;
	}

	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida {
		
		Cliente c = cliente(dni);
		//Gestion de errores
		if (c == null) {
			return null;
		}
		Seguro s = seguro(matricula);
		if (s == null) {
			return null;
		}
		
		List<Seguro> segurosC = c.getSeguros();
		
		//Comprobar los seguros del cliente
		for (Seguro seg: segurosC) {
			if (seg.getMatricula().equals(matricula)) {
				segurosC.remove(seg);
				c.setSeguros(segurosC);
				daoC.actualizaCliente(c);
				daoV.eliminaSeguro(matricula);
				return seg;
			}
		}
		
		//No pertenece al cliente
		
		throw new OperacionNoValida("El seguro no pertenece al dni del cliente indicado");
	
	}

	public Cliente nuevoCliente(Cliente c) {

		return daoC.creaCliente(c);
	}

	public Cliente bajaCliente(String dni) throws OperacionNoValida {
		
		Cliente c = cliente(dni);
		if (c.getSeguros() != null) {
			throw new OperacionNoValida("El cliente tiene seguros a su nombre");
		}

		return daoC.eliminaCliente(dni);
	}
	
	

}
