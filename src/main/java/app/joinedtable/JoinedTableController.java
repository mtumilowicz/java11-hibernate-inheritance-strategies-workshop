package app.joinedtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("joined-table")
public class JoinedTableController {

	@Autowired
	PetRepository petRepository;

	@Autowired
	WildRepository wildRepository;
	
	@GetMapping
	public Object get() {
		List<? super Animal> shapes = new LinkedList<>();
		shapes.addAll(petRepository.findAll());
		shapes.addAll(wildRepository.findAll());

		return shapes;
	}
}