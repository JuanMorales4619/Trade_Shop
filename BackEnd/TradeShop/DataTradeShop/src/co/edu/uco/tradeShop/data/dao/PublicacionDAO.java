package co.edu.uco.tradeShop.data.dao;

import co.edu.uco.TradeShop.dto.PublicacionDTO;

public interface PublicacionDAO {

	void create(PublicacionDTO publicacion);
	
	void update(PublicacionDTO publicacion);
	
	void delete(int id);

	void find(PublicacionDTO publicacion);
}
