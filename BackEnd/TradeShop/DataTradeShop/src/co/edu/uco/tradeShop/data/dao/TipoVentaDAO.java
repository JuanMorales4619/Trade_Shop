package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoVentaDTO;

public interface TipoVentaDAO {

	List<TipoVentaDTO> find(TipoVentaDTO tipoVenta);
}
