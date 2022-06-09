package co.edu.uco.tradeShop.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.TradeShop.dto.PublicacionDTO;

@RestController
@RequestMapping("/api/v1/publicacion")
public class PublicacionController {

	@GetMapping("/dummy")
	public PublicacionDTO getDummy() {
		return new PublicacionDTO();
	}
	
	@PostMapping
	public void create(@RequestBody PublicacionDTO dto) {
		System.out.println("Estoy en crear");
	}
}

