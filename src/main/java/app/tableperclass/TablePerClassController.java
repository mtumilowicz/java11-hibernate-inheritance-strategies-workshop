package app.tableperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("table-per-class")
public class TablePerClassController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping
	public Object get() {
		return personRepository.findAll();
	}
}