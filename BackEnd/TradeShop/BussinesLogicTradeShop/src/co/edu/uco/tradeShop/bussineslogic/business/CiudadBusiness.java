package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.CiudadDTO;

public interface CiudadBusiness {

	List<CiudadDTO> find(CiudadDTO ciudad);
}
