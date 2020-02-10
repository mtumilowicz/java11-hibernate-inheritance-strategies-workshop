package com.example.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {

	@Autowired
	MyEmployeeRepository myEmployeeRepository;

	@GetMapping("/get")
	public String get() {
		return myEmployeeRepository.getOne(1L).getName();
	}
}