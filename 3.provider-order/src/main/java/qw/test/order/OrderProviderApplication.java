package qw.test.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProviderApplication.class, args);
	}

}
