package co.edu.uco.tradeShop.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.TradeShop.dto.ProductoDTO;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.tradeShop.api.controller.response.Response;
import co.edu.uco.tradeShop.api.controller.validators.Validator;
import co.edu.uco.tradeShop.api.controller.validators.producto.CreateProductoValidator;
import co.edu.uco.tradeShop.bussineslogic.facade.ProductoFacade;
import co.edu.uco.tradeShop.bussineslogic.facade.impl.ProductoFacadeImpl;
import co.edu.uco.tradeShop.crosscutting.exception.TradeShopException;
import co.edu.uco.tradeShop.crosscutting.exception.enumeration.ExceptionType;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

	@GetMapping("/dummy")
	public ProductoDTO getDummy() {
		return new ProductoDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<ProductoDTO>> create(@RequestBody ProductoDTO dto) {
		
		Validator<ProductoDTO> validator = new CreateProductoValidator();
		List<String> messages = UtilObject.getUtilObject().getDefault(validator.validate(dto), new ArrayList<>());
		Response<ProductoDTO> response = new Response<>();
		ResponseEntity<Response<ProductoDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		if(messages.isEmpty()) {
			try {
			ProductoFacade facade = new ProductoFacadeImpl();
			facade.create(dto);
			messages.add("Product was created succesfully!");
			statusCode = HttpStatus.OK;
			}catch (TradeShopException exception) {
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("There was a problem trying to register the new Product. Please, try again...");
					System.err.println(exception.getMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					exception.getRootExeption().printStackTrace();
				}else {
					messages.add(exception.getMessage());
					System.err.println(exception.getMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					exception.getRootExeption().printStackTrace();
				}
			}catch (Exception exception) {
				messages.add("There was an unexpected problem trying to register the new Product. Please, try again...");
				exception.printStackTrace();
			}
		}
		response.setMessages(messages);
		responseEntity = new ResponseEntity<>(response, statusCode);
		
		return responseEntity;
	}
	
	
}
