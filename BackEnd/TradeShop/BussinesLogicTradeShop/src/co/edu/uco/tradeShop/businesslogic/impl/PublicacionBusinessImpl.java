package co.edu.uco.tradeShop.businesslogic.impl;

import co.edu.uco.TradeShop.dto.PublicacionDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.tradeShop.bussineslogic.business.PublicacionBusiness;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.data.factory.DAOFactory;

public class PublicacionBusinessImpl implements PublicacionBusiness{

private DAOFactory daoFactory;
	
	public PublicacionBusinessImpl(DAOFactory daoFactory) {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw TradeShopException.buildTechnicalBusinessLogicExeption("It´s not possible create a ProductoBussinesImpl when the DAOFactory is null");
		}
		
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(PublicacionDTO dto) {
		daoFactory.getPublicacionDAO().create(dto);
	}

	@Override
	public void update(PublicacionDTO dto) {
		daoFactory.getPublicacionDAO().update(dto);
	}

	@Override
	public void delete(int id) {
		daoFactory.getPublicacionDAO().delete(id);
	}

	@Override
	public void find(PublicacionDTO dto) {
		daoFactory.getPublicacionDAO().find(dto);
	}

}
