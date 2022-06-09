package co.edu.uco.tradeShop.bussineslogic.facade;

import co.edu.uco.TradeShop.dto.ProductoDTO;

public interface ProductoFacade {

	void create(ProductoDTO dto);
	
	void update(ProductoDTO dto);
	
	void delete(int id);

	void find(ProductoDTO dto);
}
