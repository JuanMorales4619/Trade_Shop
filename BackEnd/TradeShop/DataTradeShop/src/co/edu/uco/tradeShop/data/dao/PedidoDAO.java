package co.edu.uco.tradeShop.data.dao;

import co.edu.uco.TradeShop.dto.PedidoDTO;

public interface PedidoDAO {
	
	void create(PedidoDTO pedido);
	
	void update(PedidoDTO pedido);
	
	void delete(int id);

	void find(PedidoDTO pedido);
}
