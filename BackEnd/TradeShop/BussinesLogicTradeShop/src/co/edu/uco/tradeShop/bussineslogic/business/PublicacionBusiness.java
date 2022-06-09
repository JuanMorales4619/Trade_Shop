package co.edu.uco.tradeShop.bussineslogic.business;

import co.edu.uco.TradeShop.dto.PublicacionDTO;

public interface PublicacionBusiness {

	void create(PublicacionDTO dto);
	
	void update(PublicacionDTO dto);
	
	void delete(int id);

	void find(PublicacionDTO dto);
}
