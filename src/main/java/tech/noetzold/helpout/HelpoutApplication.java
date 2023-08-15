package tech.noetzold.helpout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HelpoutApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelpoutApplication.class, args);
	}

}
