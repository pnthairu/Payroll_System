package payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import payroll.repository.PayrollRepository;

@SpringBootApplication
public class PayrollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollSystemApplication.class, args);
	}
	
	//@Autowired
	//PayrollRepository repo;
	
	

}
