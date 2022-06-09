package co.edu.uco.tradeShop.bussineslogic.facade.impl;

import co.edu.uco.TradeShop.dto.ProductoDTO;
import co.edu.uco.tradeShop.businesslogic.impl.ProductoBusinessImpl;
import co.edu.uco.tradeShop.bussineslogic.business.ProductoBusiness;
import co.edu.uco.tradeShop.bussineslogic.facade.ProductoFacade;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.data.factory.DAOFactory;

public class ProductoFacadeImpl implements ProductoFacade{
	
	@Override
	public void create(ProductoDTO dto) {
		
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		
		try {
			daoFactory.initTransaction();
			
			ProductoBusiness productoBusiness = new ProductoBusinessImpl(daoFactory);
			productoBusiness.create(dto);
			
			daoFactory.commitTransaction();
		}catch(TradeShopException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception) {
			daoFactory.rollbackTransaction();
			var message = "There was a problem trying to create the new Product on create method in ProductoFacadeImpl";
			throw TradeShopException.buildTechnicalBusinessLogicExeption(message);
		}finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void update(ProductoDTO producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(ProductoDTO producto) {
		// TODO Auto-generated method stub
		
	}

}
