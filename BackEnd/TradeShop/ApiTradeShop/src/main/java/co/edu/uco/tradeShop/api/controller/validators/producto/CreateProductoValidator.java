package co.edu.uco.tradeShop.api.controller.validators.producto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.TradeShop.dto.ProductoDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.tradeShop.api.controller.validators.Validator;

public class CreateProductoValidator implements Validator<ProductoDTO>{

	private List<String> validationMessages = new ArrayList<>();
	
	@Override
	public List<String> validate(ProductoDTO dto) {
		
		if(UtilObject.getUtilObject().isNull(dto)) {
			validationMessages.add("It´s not posible validate Product data");
		}
		
		dto.validationName(validationMessages);
		
		return validationMessages;
	}
	
	
}
