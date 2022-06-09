package co.edu.uco.tradeShop.bussineslogic.facade;

import co.edu.uco.TradeShop.dto.PedidoDTO;

public interface PedidoFacade {
	
	void create(PedidoDTO pedido);
	
	void update(PedidoDTO pedido);
	
	void delete(int id);

	void find(PedidoDTO pedido);
}
