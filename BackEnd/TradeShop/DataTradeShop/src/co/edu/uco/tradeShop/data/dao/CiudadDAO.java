package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.CiudadDTO;

public interface CiudadDAO {

	List<CiudadDTO> find(CiudadDTO ciudad);
}
