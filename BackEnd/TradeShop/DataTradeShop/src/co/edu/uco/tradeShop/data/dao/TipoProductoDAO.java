package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoProductoDTO;

public interface TipoProductoDAO {

	List<TipoProductoDTO> find(TipoProductoDTO tipoProducto);
}
