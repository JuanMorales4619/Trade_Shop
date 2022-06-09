package co.edu.uco.tradeShop.api.controller.validators;

import java.util.List;

public interface Validator<D> {
	
	List<String> validate(D dto);
}
