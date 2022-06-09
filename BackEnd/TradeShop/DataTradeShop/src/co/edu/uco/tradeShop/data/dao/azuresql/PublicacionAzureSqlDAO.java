package co.edu.uco.tradeShop.data.dao.azuresql;

import java.sql.Connection;

import co.edu.uco.TradeShop.dto.PublicacionDTO;
import co.edu.uco.tradeShop.dao.connection.ConnectionSQL;
import co.edu.uco.tradeShop.data.dao.PublicacionDAO;

public class PublicacionAzureSqlDAO extends ConnectionSQL implements PublicacionDAO{

	private PublicacionAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static PublicacionDAO create(Connection connection) {
		return new PublicacionAzureSqlDAO(connection);
	}
	
	@Override
	public void create(PublicacionDTO publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PublicacionDTO publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(PublicacionDTO publicacion) {
		// TODO Auto-generated method stub
		
	}
	
}
