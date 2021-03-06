package co.edu.uco.tradeShop.data.factory.azuresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.tradeShop.crosscutting.exception.enumeration.ExceptionType;
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
import co.edu.uco.tradeShop.data.dao.azuresql.CiudadAzureSqlDAO;
import co.edu.uco.tradeShop.data.dao.azuresql.ProductoAzureSqlDAO;
import co.edu.uco.tradeShop.data.dao.azuresql.PublicacionAzureSqlDAO;
import co.edu.uco.tradeShop.data.factory.DAOFactory;

public class AzureSqlDAOFactory extends DAOFactory{

private Connection connection;
	
	private AzureSqlDAOFactory() {
		openConnection();
	}
	
	public static DAOFactory create() {
		return new AzureSqlDAOFactory();
	}
	
	@Override
	public void initTransaction() {
		if(UtilConnection.isClosed(getConnection())){
			throw TradeShopException.buildTechnicalExeption("it's not possible to init the transaction because the connection is close");
		}
		
		try {
			if(!getConnection().getAutoCommit()){
				throw TradeShopException.buildTechnicalExeption("it's not possible to init the transaction because it was already initiated");
			}
			getConnection().setAutoCommit(false);
		}
		catch(SQLException exception) {
			throw TradeShopException.buildTechnicalExeption("There was a problem tryin to init with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
		}
		 catch(Exception exception) {
				throw TradeShopException.buildTechnicalExeption("An unexpected problem has ocurred tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
			}
	}

	@Override
	public void commitTransaction() {
		if(UtilConnection.isClosed(connection)){
			throw TradeShopException.buildTechnicalExeption("it's not possible to commit the transaction because the connection is close");
		} 
		
		
		try {
			if(getConnection().getAutoCommit()){
				throw TradeShopException.buildTechnicalExeption("it's not possible to commit the transaction because the database is managin the ");
			}
			getConnection().commit();
		}catch(TradeShopException exception) {
			throw exception;
		}
		catch(SQLException exception) {
			throw TradeShopException.buildTechnicalExeption("There was a problem tryin to commit with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
			exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
		}
		 catch(Exception exception) {
				throw TradeShopException.buildTechnicalExeption("An unexpected problem has ocurred tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
			}
	}
	
	

	@Override
	public void rollbackTransaction() {
		if(UtilConnection.isClosed(connection)){
			throw TradeShopException.buildTechnicalExeption("it's not possible to rollback the transaction because the connection is close");
		}
		
		try {
			if(getConnection().getAutoCommit()){
				throw TradeShopException.buildTechnicalExeption("it's not possible to rollback the transaction because the database is managin the ");
			}
			getConnection().rollback();
		}
		catch(TradeShopException exception) {
			throw exception;
		}
		catch(SQLException exception) {
			throw TradeShopException.buildTechnicalExeption("There was a problem tryin to rollback with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
		}
		 catch(Exception exception) {
				throw TradeShopException.buildTechnicalExeption("An unexpected problem has ocurred tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
						exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
			}
	}

	@Override
	protected void openConnection() {
		String stringConnection = "jdbc:sqlserver://tradeshop-database-server2.database.windows.net:1433;database=trade-shop2;user=tradeshop;password=TdSp123#;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			connection = DriverManager.getConnection(stringConnection);
		}
		catch(SQLException exception) {
			throw TradeShopException.buildTechnicalExeption("There was a problem tryin to get the connection with sql server at jdbc:sqlserver://tradeshop-database-server.database.windows.net:1433;database=TradeShop-DB;user=tradeshop;",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
		}
		 catch(Exception exception) {
				throw TradeShopException.buildTechnicalExeption("An unexpected problem has ocurred tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
						exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
			}
	}
	
	/*public static void main(String[] args) {
		try {
		AzureSqlDAOFactory azure = new AzureSqlDAOFactory();
		System.out.println("Conexion obtenida exitosamente");
		}catch(TradeShopException exception) {
			System.out.println(exception.getTecnicalMessage());
			System.out.println(exception.getType());
			exception.printStackTrace();
		}catch(Exception exception) {
			System.out.println("Este camino no lo tenia controlado!!!");
		}
	}*/

	
	
	@Override
	public void closeConection() {
		if(UtilConnection.isClosed(connection)){
			throw TradeShopException.buildTechnicalExeption("it's not possible close a connection because it's alredy is closed or is null");
	}
		try {
			getConnection().close();
		}
		catch(SQLException exception) {
			throw TradeShopException.buildTechnicalExeption("There was a problem tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
					exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
		}
		 catch(Exception exception) {
				throw TradeShopException.buildTechnicalExeption("An unexpected problem has ocurred tryin to get the connection with sql server at jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser",
						exception, ExceptionType.TECHNICAL, ExceptionLocation.DATA );
			}
	}

	@Override
	protected Connection getConnection() {
		return connection;
		
	}

	@Override
	public PublicacionDAO getPublicacionDAO() {
		return PublicacionAzureSqlDAO.create(getConnection());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return CiudadAzureSqlDAO.create(getConnection());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoPedidoDAO getEstadoPedidoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialPedidoDAO getHistorialPedidoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NovedadDAO getNovedadDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDAO getPaisDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDAO getPedidoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return ProductoAzureSqlDAO.create(getConnection());
	}

	@Override
	public TipoIdentificacionDAO getTipoIdentificacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoProductoDAO getTipoProductoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVentaDAO getTipoVentaDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
