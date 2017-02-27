package com.practice.spring;

import com.practice.spring.domain.Customer;
import com.practice.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiServerApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiServerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		customerRepository.save(new Customer("Lyndon", "Bibera"));
		customerRepository.save(new Customer("Lelouch", "Lamperouge"));

	}
}
