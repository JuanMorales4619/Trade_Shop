package co.edu.uco.tradeShop.businesslogic.impl;


import co.edu.uco.TradeShop.dto.ProductoDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.tradeShop.bussineslogic.business.ProductoBusiness;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.data.factory.DAOFactory;

public class ProductoBusinessImpl implements ProductoBusiness{

	private DAOFactory daoFactory;
	
	public ProductoBusinessImpl(DAOFactory daoFactory) {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw TradeShopException.buildTechnicalBusinessLogicExeption("It?s not possible create a ProductoBussinesImpl when the DAOFactory is null");
		}
		
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(ProductoDTO dto) {
		daoFactory.getProductoDAO().create(dto);
	}

	@Override
	public void update(ProductoDTO dto) {
		daoFactory.getProductoDAO().update(dto);
	}

	@Override
	public void delete(int id) {
		daoFactory.getProductoDAO().delete(id);
	}

	@Override
	public void find(ProductoDTO dto) {
		daoFactory.getProductoDAO().find(dto);
	}

}
