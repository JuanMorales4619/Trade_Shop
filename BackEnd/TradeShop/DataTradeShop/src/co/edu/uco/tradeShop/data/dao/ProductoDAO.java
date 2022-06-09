package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.ProductoDTO;

public interface ProductoDAO {

	void create(ProductoDTO producto);
	
	void update(ProductoDTO producto);
	
	void delete(int id);

	List<ProductoDTO> find(ProductoDTO producto);
}
