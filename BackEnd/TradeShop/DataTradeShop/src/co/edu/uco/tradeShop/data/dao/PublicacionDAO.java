package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.PublicacionDTO;

public interface PublicacionDAO {

	void create(PublicacionDTO publicacion);
	
	void update(PublicacionDTO publicacion);
	
	void delete(int id);

	List<PublicacionDTO> find(PublicacionDTO publicacion);
}
