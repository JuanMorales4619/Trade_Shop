package co.edu.uco.tradeShop.bussineslogic.business;

import java.util.List;

import co.edu.uco.TradeShop.dto.DepartamentoDTO;

public interface DepartamentoBussines {

	List<DepartamentoDTO> find(DepartamentoDTO departamento);
}
