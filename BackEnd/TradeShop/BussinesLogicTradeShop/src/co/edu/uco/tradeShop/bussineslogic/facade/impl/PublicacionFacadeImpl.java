package co.edu.uco.tradeShop.bussineslogic.facade.impl;

import co.edu.uco.TradeShop.dto.PublicacionDTO;
import co.edu.uco.tradeShop.businesslogic.impl.PublicacionBusinessImpl;
import co.edu.uco.tradeShop.bussineslogic.business.PublicacionBusiness;
import co.edu.uco.tradeShop.bussineslogic.facade.PublicacionFacade;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.data.factory.DAOFactory;

public class PublicacionFacadeImpl implements PublicacionFacade{

	@Override
	public void create(PublicacionDTO dto) {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		
		try {
			daoFactory.initTransaction();
			
			PublicacionBusiness publicacionBusiness = new PublicacionBusinessImpl(daoFactory);
			publicacionBusiness.create(dto);
			
			daoFactory.commitTransaction();
		}catch(TradeShopException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception) {
			daoFactory.rollbackTransaction();
			var message = "There was a problem trying to create the new Publicacion on create method in ProductoFacadeImpl";
			throw TradeShopException.buildTechnicalBusinessLogicExeption(message);
		}finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void update(PublicacionDTO publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(PublicacionDTO publicacion) {
		// TODO Auto-generated method stub
		
	}

}
