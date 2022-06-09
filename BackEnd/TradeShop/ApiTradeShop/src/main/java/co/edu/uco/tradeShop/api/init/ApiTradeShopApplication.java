package co.edu.uco.tradeShop.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.tradeShop"})
public class ApiTradeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTradeShopApplication.class, args);
	}

}
