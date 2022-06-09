package co.edu.uco.tradeShop.bussineslogic.business;

import co.edu.uco.TradeShop.dto.ProductoDTO;

public interface ProductoBusiness {

	void create(ProductoDTO dto);
	
	void update(ProductoDTO dto);
	
	void delete(int id);

	void find(ProductoDTO dto);
}
