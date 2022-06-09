package co.edu.uco.tradeShop.bussineslogic.business;

import co.edu.uco.TradeShop.dto.HistorialPedidoDTO;

public interface HistorialPedidoBusiness {

	void find(HistorialPedidoDTO historialPedido);
	
	void delete(int id);
}
