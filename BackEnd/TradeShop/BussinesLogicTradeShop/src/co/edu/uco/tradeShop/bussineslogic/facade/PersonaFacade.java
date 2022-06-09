package co.edu.uco.tradeShop.bussineslogic.facade;

import co.edu.uco.TradeShop.dto.PersonaDTO;

public interface PersonaFacade {

	void create(PersonaDTO persona);
	
	void update(PersonaDTO persona);
	
	void delete(int id);

	void find(PersonaDTO persona);
}
