package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.TipoIdentificacionDTO;

public interface TipoIdentificacionBusiness {

	List<TipoIdentificacionDTO> find(TipoIdentificacionDTO tipoIdentificacion);
}
