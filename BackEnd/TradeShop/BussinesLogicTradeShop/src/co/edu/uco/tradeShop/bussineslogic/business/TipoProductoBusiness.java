package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoProductoDTO;

public interface TipoProductoBusiness {

	List<TipoProductoDTO> find(TipoProductoDTO tipoProducto);
}
