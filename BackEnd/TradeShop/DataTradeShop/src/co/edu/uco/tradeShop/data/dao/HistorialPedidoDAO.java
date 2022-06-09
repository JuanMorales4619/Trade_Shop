package co.edu.uco.tradeShop.data.dao;

import co.edu.uco.TradeShop.dto.HistorialPedidoDTO;

public interface HistorialPedidoDAO {

	void find(HistorialPedidoDTO historialPedido);
	
	void delete(int id);
}
