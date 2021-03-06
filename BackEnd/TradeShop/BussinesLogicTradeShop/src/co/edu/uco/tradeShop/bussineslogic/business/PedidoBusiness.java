package co.edu.uco.tradeShop.bussineslogic.business;

import co.edu.uco.TradeShop.dto.PedidoDTO;

public interface PedidoBusiness {
	
	void create(PedidoDTO pedido);
	
	void update(PedidoDTO pedido);
	
	void delete(int id);

	void find(PedidoDTO pedido);
}
