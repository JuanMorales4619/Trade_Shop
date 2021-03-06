package co.edu.uco.tradeShop.bussineslogic.business;

import co.edu.uco.TradeShop.dto.PersonaDTO;

public interface PersonaBusiness {

	void create(PersonaDTO persona);
	
	void update(PersonaDTO persona);
	
	void delete(int id);

	void find(PersonaDTO persona);
}
