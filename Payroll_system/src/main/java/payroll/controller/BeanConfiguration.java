package payroll.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import payroll.beans.Departments;
import payroll.beans.Employees;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Departments departments() {		
		Departments bean = new Departments();		
		return bean;	
	}
	
	@Bean
	public Employees employee() {		
		Employees bean = new Employees();	
		return bean;	
	}

}
