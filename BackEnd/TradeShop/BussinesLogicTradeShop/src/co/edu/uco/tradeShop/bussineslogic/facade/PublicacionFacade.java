package co.edu.uco.tradeShop.bussineslogic.facade;

import co.edu.uco.TradeShop.dto.PublicacionDTO;

public interface PublicacionFacade {

	void create(PublicacionDTO dto);
	
	void update(PublicacionDTO dto);
	
	void delete(int id);

	void find(PublicacionDTO dto);
}
