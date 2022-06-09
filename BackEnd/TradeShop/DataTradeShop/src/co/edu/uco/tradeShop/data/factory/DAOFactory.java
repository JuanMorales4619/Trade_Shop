package co.edu.uco.tradeShop.data.factory;

import java.sql.Connection;

import co.edu.uco.tradeShop.data.dao.CiudadDAO;
import co.edu.uco.tradeShop.data.dao.DepartamentoDAO;
import co.edu.uco.tradeShop.data.dao.EstadoPedidoDAO;
import co.edu.uco.tradeShop.data.dao.HistorialPedidoDAO;
import co.edu.uco.tradeShop.data.dao.NovedadDAO;
import co.edu.uco.tradeShop.data.dao.PaisDAO;
import co.edu.uco.tradeShop.data.dao.PedidoDAO;
import co.edu.uco.tradeShop.data.dao.PersonaDAO;
import co.edu.uco.tradeShop.data.dao.ProductoDAO;
import co.edu.uco.tradeShop.data.dao.PublicacionDAO;
import co.edu.uco.tradeShop.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tradeShop.data.dao.TipoProductoDAO;
import co.edu.uco.tradeShop.data.dao.TipoVentaDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDaoFactory() {
		return null;
	}
	
	public abstract void commitTransaction();
	
	public abstract void rollbackTransaction();
	
	protected abstract void openConnection();
	
	protected abstract Connection getConnection();
	
	public abstract void initTransaction();
	
	
	public void closeConection() {
		
	}
	
	public abstract PublicacionDAO getPublicacionDAO();
	
	public abstract CiudadDAO getCiudadDAO();
	
	public abstract DepartamentoDAO getDepartamentoDAO();
	
	public abstract EstadoPedidoDAO getEstadoPedidoDAO();
	
	public abstract HistorialPedidoDAO getHistorialPedidoDAO();
	
	public abstract NovedadDAO getNovedadDAO();
	
	public abstract PaisDAO getPaisDAO();
	
	public abstract PedidoDAO getPedidoDAO();
	
	public abstract PersonaDAO getPersonaDAO();
	
	public abstract ProductoDAO getProductoDAO();
	
	public abstract TipoIdentificacionDAO getTipoIdentificacionDAO();
	
	public abstract TipoProductoDAO getTipoProductoDAO();
	
	public abstract TipoVentaDAO getTipoVentaDAO();
}


