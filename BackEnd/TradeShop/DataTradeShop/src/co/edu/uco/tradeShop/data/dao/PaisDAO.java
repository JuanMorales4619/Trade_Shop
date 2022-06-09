package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.PaisDTO;

public interface PaisDAO {
	
	List<PaisDTO> find(PaisDTO pais);
}
