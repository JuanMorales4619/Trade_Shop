package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.PaisDTO;

public interface PaisBusiness {

	List<PaisDTO> find(PaisDTO pais);
}
