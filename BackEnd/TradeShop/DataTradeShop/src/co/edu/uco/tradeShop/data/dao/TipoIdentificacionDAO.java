package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoIdentificacionDTO;

public interface TipoIdentificacionDAO {
	
	List<TipoIdentificacionDTO> find(TipoIdentificacionDTO tipoIdentificacion);
}
