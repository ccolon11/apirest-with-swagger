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
	ApplicationContext context = SpringApplication.run(ApirestWithSwaggerApplication.class, args);
	HardwareRepository repository = context.getBean(HardwareRepository.class);
	// all the next code  for test the different methods in console
	// CRUD
	// create hardaware
	Hardware hardware1 = new Hardware(null,"screwdriver","phillips",3.33,true,13);
	Hardware hardware2 = new Hardware(null,"screwdriver","plane",3.20,true,1);
	Hardware hardware3 = new Hardware(null,"nail","flat head",0.60,true,1);
	Hardware hardware4 = new Hardware(null,"nail","missing head",0.60,true,1);
	//to store hardware
		System.out.println("hardware number in database: " + repository.findAll().size());

		repository.save(hardware1);
		repository.save(hardware2);
		repository.save(hardware3);
		repository.save(hardware4);

	// retrieve all hardware
		System.out.println("hardware number in database: " + repository.findAll().size());

	// to delete an hardware
	// repository.deleteById(1L);

		System.out.println("hardware number in database: " + repository.findAll().size());

    // quantity bought of same type hardware
		double quantity = HardwarePriceCalculator.calculatePrice(hardware1);

		System.out.println(quantity);
   }
}
