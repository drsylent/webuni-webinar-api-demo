package hu.webuni.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebinarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebinarApiApplication.class, args);
	}

}
