package co.edu.uco.tradeShop.dao.connection;

import java.sql.Connection;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;

public class ConnectionSQL {
	
	private Connection connection;

	protected ConnectionSQL(Connection connection) {
		if(UtilConnection.isClosed(connection)) {
			throw TradeShopException.buildTechnicalDataExeption("it's not possible to create the specific DAO because the conection is closed");
		}
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}
}
