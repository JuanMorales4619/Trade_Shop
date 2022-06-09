package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoVentaDTO;

public interface TipoVentaBusiness {

	List<TipoVentaDTO> find(TipoVentaDTO tipoVenta);
}
