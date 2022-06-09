package co.edu.uco.tradeShop.data.dao;

import co.edu.uco.TradeShop.dto.ProductoDTO;

public interface ProductoDAO {

	void create(ProductoDTO producto);
	
	void update(ProductoDTO producto);
	
	void delete(int id);

	void find(ProductoDTO producto);
}
