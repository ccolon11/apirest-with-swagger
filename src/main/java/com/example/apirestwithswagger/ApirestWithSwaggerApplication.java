package com.example.apirestwithswagger;
import com.example.apirestwithswagger.service.HardwarePriceCalculator;
import com.example.apirestwithswagger.entities.Hardware;
import com.example.apirestwithswagger.repository.HardwareRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class ApirestWithSwaggerApplication {

	public static void main(String[] args) {
	 SpringApplication.run(ApirestWithSwaggerApplication.class, args);
   }
}
