package co.edu.uco.tradeShop.data.dao;

import java.util.List;

import co.edu.uco.TradeShop.dto.DepartamentoDTO;

public interface DepartamentoDAO {

	List<DepartamentoDTO> find(DepartamentoDTO departamento);
}
