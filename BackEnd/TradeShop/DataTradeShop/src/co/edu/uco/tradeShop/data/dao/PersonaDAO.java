package co.edu.uco.tradeShop.data.dao;

import co.edu.uco.TradeShop.dto.PersonaDTO;

public interface PersonaDAO {
	
	void create(PersonaDTO persona);
	
	void update(PersonaDTO persona);
	
	void delete(int id);

	void find(PersonaDTO persona);
}
